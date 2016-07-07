/*
 * Copyright 2008-2016 Walking Tree LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kaaproject.kaa.server.appenders.pubnub.appender;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.kaaproject.kaa.common.dto.logs.LogAppenderDto;
import org.kaaproject.kaa.common.dto.logs.LogEventDto;
import org.kaaproject.kaa.server.appenders.pubnub.config.gen.PubNubConfig;
import org.kaaproject.kaa.server.appenders.pubnub.appender.LogEvent;
import org.kaaproject.kaa.server.appenders.pubnub.appender.LogEventPubnubDao;
import org.kaaproject.kaa.server.appenders.pubnub.appender.LogEventDao;
import org.kaaproject.kaa.server.appenders.pubnub.config.PubNubAppenderConfig;
import org.kaaproject.kaa.server.common.log.shared.appender.AbstractLogAppender;
import org.kaaproject.kaa.server.common.log.shared.appender.LogDeliveryCallback;
import org.kaaproject.kaa.server.common.log.shared.appender.LogEventPack;
import org.kaaproject.kaa.server.common.log.shared.appender.data.ProfileInfo;
import org.kaaproject.kaa.server.common.log.shared.avro.gen.RecordHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PubNubLogAppender extends AbstractLogAppender<PubNubConfig> {

    private static final Logger LOG = LoggerFactory.getLogger(PubNubLogAppender.class);
    
    private LogEventDao logEventDao;
    private boolean closed = false;

    public PubNubLogAppender() {
    	super(PubNubConfig.class);
    }
    
    /**
     * Inits the appender from configuration.
     *
     * @param appender the metadata object that contains useful info like application token, tenant id, etc.
     * @param configuration the configuration object that you have specified during appender provisioning.
     */
    @Override
    protected void initFromConfiguration(LogAppenderDto appender, PubNubConfig configuration) {
        //Do some initialization here.
    	LOG.info("***** Initializing PubNub Appender Configuration......=>" + configuration.getSubscribeKey());
    	try {
			this.logEventDao = new LogEventPubnubDao(configuration);
        } catch (Exception e) {
            LOG.error("Failed to init PubNub log appender: ", e);
        }
    }

    @Override
    public void doAppend(LogEventPack logEventPack, RecordHeader header, LogDeliveryCallback listener) {
    	LOG.info("***** Appending PubNub logs......");
    	
    	if (!closed) {
            try {
                LOG.debug("[{}] appending {} logs to PubNub channel", getApplicationToken(), logEventPack.getEvents().size());
                List<LogEventDto> dtos = generateLogEvent(logEventPack, header);
                LOG.debug("[{}] saving {} objects", getApplicationToken(), dtos.size());
                if (!dtos.isEmpty()) {
                	this.logEventDao.publish(header, dtos);
                    LOG.debug("[{}] published {} logs to PubNub channel", getApplicationToken(), logEventPack.getEvents().size());
                }
                listener.onSuccess();
            } catch (Exception e) {
                LOG.error(MessageFormat.format("[{0}] Attempted to publish logs failed due to internal error", getName()), e);
                listener.onInternalError();
            }
        } else {
            LOG.info("Attempted to publish to closed appender named [{}].", getName());
            listener.onInternalError();
        }
    }
    
    /**
     * Closes this appender and releases any resources associated with it.
     *
     */
    @Override
    public void close() {
        //Free allocated resources here.
    	LOG.info("***** Closing PubNub Appender......");
    	if (!closed) {
            closed = true;
            if (logEventDao != null) {
                logEventDao.close();
                logEventDao = null;
            }
        }
        LOG.debug("Stoped PubNub log appender.");
    }
}

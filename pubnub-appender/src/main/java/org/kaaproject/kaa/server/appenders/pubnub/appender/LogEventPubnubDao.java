package org.kaaproject.kaa.server.appenders.pubnub.appender;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.kaaproject.kaa.common.dto.logs.LogEventDto;
import org.kaaproject.kaa.server.appenders.pubnub.config.gen.PubNubConfig;
import org.kaaproject.kaa.server.common.log.shared.avro.gen.RecordHeader;

import com.pubnub.api.*;
import com.pubnub.api.callbacks.PNCallback;
import com.pubnub.api.models.consumer.PNPublishResult;
import com.pubnub.api.models.consumer.PNStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogEventPubnubDao implements LogEventDao {

    private static final Logger LOG = LoggerFactory.getLogger(LogEventPubnubDao.class);

    private PubNub pubNub;

    public LogEventPubnubDao(PubNubConfig configuration) throws Exception {
    	
    	PNConfiguration pnConfiguration = new PNConfiguration();
    	pnConfiguration.setSubscribeKey(configuration.getSubscribeKey().toString());
    	pnConfiguration.setPublishKey(configuration.getPublishKey().toString());
    	
    	this.pubNub = new PubNub(pnConfiguration);
    }

    @Override
    public List<LogEvent> publish(RecordHeader recordHeader, List<LogEventDto> logEventDtos) throws Exception{
        List<LogEvent> logEvents = new ArrayList<>(logEventDtos.size());
        for (LogEventDto logEventDto : logEventDtos) {
            LogEvent logEvent = new LogEvent(recordHeader, logEventDto);
            
            logEvents.add(logEvent);
            
            LOG.debug("Publishing {} log event with configuration {}", logEvent, this.pubNub);
            try {
            this.pubNub.publish()
            		.message(logEvent.getEvent())
            		.channel(logEvent.getChannel())
            		.usePOST(true)
            		.sync();
            } catch (PubNubException pnex) {
            	LOG.debug("Got PubNubException... {} exception", pnex);
            	throw pnex;
            }
            LOG.debug("Log {} published to channel.", logEvent.getEvent());
        }
        return logEvents;
    }

    @Override
    public void close() {
    	//No operation
    }
}

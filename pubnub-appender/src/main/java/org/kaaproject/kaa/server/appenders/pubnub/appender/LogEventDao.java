package org.kaaproject.kaa.server.appenders.pubnub.appender;

import java.util.List;

import org.kaaproject.kaa.common.dto.logs.LogEventDto;
import org.kaaproject.kaa.server.common.log.shared.avro.gen.RecordHeader;

import com.pubnub.api.*;

public interface LogEventDao {
	
    List<LogEvent> publish(RecordHeader header, List<LogEventDto> logEventDtos) throws Exception;
    
    void close();
    
}

package org.kaaproject.kaa.server.appenders.pubnub.appender;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import org.kaaproject.kaa.common.dto.logs.LogEventDto;
import org.kaaproject.kaa.server.common.log.shared.avro.gen.RecordHeader;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.codehaus.jackson.map.ObjectMapper;

public final class LogEvent implements Serializable {

    private static final long serialVersionUID = -1L;

    private RecordHeader header;
    private String channel;
    private HashMap<String, String> event;

    public LogEvent() {}

    public LogEvent(RecordHeader header, LogEventDto dto) {
        this.header = header;
        
        Gson gson = new Gson();
		
		
		Type fooType = new TypeToken<HashMap<String, Object>>() {}.getType();
		Type fooType1 = new TypeToken<HashMap<String, String>>() {}.getType();
		
		HashMap<String, Object> map1 = gson.fromJson(dto.getEvent(), fooType);

		this.channel = map1.get("channel").toString();
		
		HashMap<String, String> msg = gson.fromJson(gson.toJson(map1.get("message")), fooType1);
		
//		System.out.println(map2.get("value").toString());
		
//        HashMap<String, String> msg = new HashMap<String, String>();
//        msg.put("value", "43");
//        msg.put("since", "06:00 AM");
        
//        JSONObject paylod = data.getJSONObject("message"); 
//        ObjectMapper mapper = new ObjectMapper();
//        Class clazz = (Class) Class.forName(HashMap.class);
//        msg = mapper.convertValue(paylod, clazz);
        
//        ObjectMapper mapper = new ObjectMapper();
//        TypeFactory typeFactory = mapper.getTypeFactory();
//        MapType mapType = typeFactory.constructMapType(HashMap.class, String.class, String.class);
//        HashMap<String, String> map = mapper.readValue(new StringReader(hashTable.toString()), mapType);
        
        this.event = msg;
    }
    
    RecordHeader getHeader() {
    	return this.header;
    }
    
    void setHeader(RecordHeader header) {
    	this.header = header;
    }
    
    String getChannel() {
    	return this.channel;
    }
    
    void setChannel(String channel) {
    	this.channel = channel;
    }
    
    HashMap<String, String> getEvent() {
    	return this.event;
    }
    
    void setEvent(HashMap<String, String> event) {
    	this.event = event;
    }


    @Override
    public String toString() {
        return "LogEvent [channel=" + channel + ", header=" + header + ", event=" + event + "]";
    }

}
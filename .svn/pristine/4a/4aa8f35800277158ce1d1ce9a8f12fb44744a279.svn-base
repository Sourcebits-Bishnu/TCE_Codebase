package com.tce.common.util;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository("jsonUtil")
public class JSONUtil {

	private ObjectMapper mapper = new ObjectMapper();
	
	@PostConstruct
	void init() {
		mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
	}


	public String writer(Object obj) {
		try {
			String jsonStr="";
			if(obj != null) {			
				StringWriter writer = new StringWriter();
				mapper.writeValue(writer, obj);
				jsonStr = writer.toString();
			}
			return jsonStr;
		} catch (IOException ioe) {
			return ioe.getMessage();
		}
	}


	
	public <E> E readAsClass(String jsonString,Class<E> template) throws IOException {		
		return (E)mapper.readValue(jsonString, template);
	}
	
	
	public <E> List<E> readAsList(String jsonString,Class<E> template) throws IOException {		
		return mapper.readValue(jsonString, mapper.getTypeFactory().constructCollectionType(List.class, template));
	}	
	
	
	public <K, V> Map<K, V> readAsMap(String jsonString,Class<K> key,Class<V> value) throws IOException {	
		if(jsonString == null || jsonString.trim().length() == 0) {
			return null;
		}
		return mapper.readValue(jsonString, mapper.getTypeFactory().constructMapType(Map.class, key, value));
	}
	
	public <K, V> Map<K, List<V>> readAsListMap(String jsonString,Class<K> key,Class<V> value) throws IOException {	
		JavaType valueType = mapper.getTypeFactory().constructCollectionType(List.class, value);
		JavaType keyType = mapper.getTypeFactory().constructType(key);
		return mapper.readValue(jsonString, mapper.getTypeFactory().constructMapType(Map.class, keyType, valueType));
	}
	

	public String extract(String jsonData,String key)throws IOException{		
		return (readAsMap(jsonData,String.class,String.class)).get(key);
	}

}

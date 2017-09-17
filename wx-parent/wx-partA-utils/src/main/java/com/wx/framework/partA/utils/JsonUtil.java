package com.wx.framework.partA.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON ������
 * @author Administrator
 *
 */
public class JsonUtil {
	
	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	/**
	 * ��pojo תΪ json
	 * @param t
	 * @return
	 */
	public static <T> String toJson(T t){
		String json = null;
		try {
			json = objectMapper.writeValueAsString(t);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	/**
	 * �� pojo תΪ json
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T toPojo(String json, Class<T> clazz){
		T t = null;
		try {
			t = objectMapper.readValue(json, clazz);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
}

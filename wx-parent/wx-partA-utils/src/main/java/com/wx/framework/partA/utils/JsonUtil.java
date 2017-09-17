package com.wx.framework.partA.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON 工具类
 * @author Administrator
 *
 */
public class JsonUtil {
	
	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	/**
	 * 将pojo 转为 json
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
	 * 将 pojo 转为 json
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

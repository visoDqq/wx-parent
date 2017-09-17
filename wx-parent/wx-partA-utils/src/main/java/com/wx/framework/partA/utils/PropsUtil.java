package com.wx.framework.partA.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PropsUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(PropsUtil.class);
	
	public static Properties propLoads(String fileName){
        Properties prop = null;
        InputStream in = null;
        try{
        	in = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
        	if (in == null) {
				throw new FileNotFoundException(fileName + " is not found");
			}
        	
        	prop = new Properties();
            prop.load(in);
        }
        catch(Exception e){
        	logger.error("load properties file failure", e);
        }finally{
        	if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					logger.error("close inputStream failure" , e);
				}
			}
        }
        return prop;
	}
	
	/**
	 * 获取字符串属性（默认为空字符串）
	 * @param props
	 * @param key
	 * @return
	 */
	public static String getString(Properties props, String key){
		return getString(props, key, "");
	}
	
	/**
	 * 获取字符串属性（可指定默认值）
	 * @param props
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static String getString(Properties props, String key, String defaultValue){
		String value = defaultValue;
		if (props.containsKey(key)) {
			value = props.getProperty(key);
		}
		return value;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

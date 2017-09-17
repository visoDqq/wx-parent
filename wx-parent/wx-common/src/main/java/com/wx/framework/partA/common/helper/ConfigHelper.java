package com.wx.framework.partA.common.helper;

import java.io.InputStream;
import java.util.Properties;


public final class ConfigHelper {

	public static String propLoads(String fileName, String key){
        Properties prop = new Properties();     
        InputStream in = null;
        String value = "";
        try{
        	in = ConfigHelper.class.getClassLoader().getResourceAsStream(fileName+".properties");
            prop.load(in);
            value = prop.getProperty(key);
            in.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return value;
	}
}

package com.wx.framework.partA.test;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

public final class ConfigHelper {
    public static void main(String[] args) { 
        Properties prop = new Properties();     
        try{
        	InputStream in = ConfigHelper.class.getClassLoader().getResourceAsStream("wx-partA.properties");
            prop.load(in);
            Iterator<String> it=prop.stringPropertyNames().iterator();
            while(it.hasNext()){
                String key=it.next();
                System.out.println(key+":"+prop.getProperty(key));
            }
            in.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    } 
}

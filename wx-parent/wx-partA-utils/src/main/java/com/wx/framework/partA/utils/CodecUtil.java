package com.wx.framework.partA.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class CodecUtil {

	
	/**
	 * ½«url±àÂë
	 * @param source
	 * @return
	 */
	public static String encodeUrl(String source){
		String target = null;
		try {
			target = URLEncoder.encode(source,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return target;
	}
	
	public static String decodeUrl(String source){
		String target = null;
		try {
			target = URLDecoder.decode(source, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return target;
	}
}

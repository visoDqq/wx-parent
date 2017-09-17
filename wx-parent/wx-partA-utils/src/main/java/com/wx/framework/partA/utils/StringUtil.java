package com.wx.framework.partA.utils;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {

	
	/**
	 * ÅÐ¶Ï×Ö·û´®ÊÇ·ñÎª¿Õ
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if (str != null) {
			str = str.trim();
		}
		return StringUtils.isEmpty(str);
	}
	/**
	 * ÅÐ¶Ï×Ö·û´®ÊÇ·ñ·Ç¿Õ
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}
}

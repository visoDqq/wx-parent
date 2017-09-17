package com.wx.framework.partA.utils;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {

	
	/**
	 * �ж��ַ����Ƿ�Ϊ��
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
	 * �ж��ַ����Ƿ�ǿ�
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		return !isEmpty(str);
	}
}

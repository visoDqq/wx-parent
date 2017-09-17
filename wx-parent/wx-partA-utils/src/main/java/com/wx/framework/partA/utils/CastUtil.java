package com.wx.framework.partA.utils;

public class CastUtil {

	
	
	/**
	 * 转换成string类型（可指定默认值）
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static String castString(Object obj, String defaultValue){
		return obj != null ? String.valueOf(obj) : defaultValue;
	}
	
	/**
	 * 转换成string类型
	 * @param obj
	 * @return
	 */
	public static String castString(Object obj){
		return CastUtil.castString(obj,"");
	}
	
	/**
	 * 转换成long类型（可指定默认值）
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static long castLong(Object obj, long defaultValue){
		long longValue = defaultValue;
		if (obj != null) {
			String strValue = CastUtil.castString(obj);
			if (StringUtil.isNotEmpty(strValue)) {
				try {
					longValue = Long.valueOf(strValue);
				} catch (NumberFormatException e) {
					longValue = defaultValue;
				}
			}
		}
		return longValue;
	}
	/**
	 * 转换成long类型
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static long castLong(Object obj){
		return CastUtil.castLong(obj,0);
	}
	
	/**
	 * 转换成int类型（可指定默认值）
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static int castInt(Object obj, int defaultValue){
		int intValue = defaultValue;
		if (obj != null) {
			String strValue = CastUtil.castString(obj);
			if (StringUtil.isNotEmpty(strValue)) {
				try {
					intValue = Integer.valueOf(strValue);
				} catch (NumberFormatException e) {
					intValue = defaultValue;
				}
			}
		}
		return intValue;
	}
	/**
	 * 转换成int类型
	 * @param obj
	 * @return
	 */
	public static int castInt(Object obj){
		return CastUtil.castInt(obj, 0);
	}
	
	/**
	 * 转换成double类型（可指定默认值）
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static double castDouble(Object obj, double defaultValue){
		double doubleValue = defaultValue;
		if (obj != null) {
			String strValue = CastUtil.castString(obj);
			if (StringUtil.isNotEmpty(strValue)) {
				try {
					doubleValue = Double.valueOf(strValue);
				} catch (NumberFormatException e) {
					doubleValue = defaultValue;
				}
			}
		}
		return doubleValue;
	}
	/**
	 * 转换成double类型
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static double castDouble(Object obj){
		return CastUtil.castDouble(obj, 0);
	}
	
}

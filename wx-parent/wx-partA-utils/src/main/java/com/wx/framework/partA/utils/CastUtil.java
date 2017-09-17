package com.wx.framework.partA.utils;

public class CastUtil {

	
	
	/**
	 * ת����string���ͣ���ָ��Ĭ��ֵ��
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static String castString(Object obj, String defaultValue){
		return obj != null ? String.valueOf(obj) : defaultValue;
	}
	
	/**
	 * ת����string����
	 * @param obj
	 * @return
	 */
	public static String castString(Object obj){
		return CastUtil.castString(obj,"");
	}
	
	/**
	 * ת����long���ͣ���ָ��Ĭ��ֵ��
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
	 * ת����long����
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static long castLong(Object obj){
		return CastUtil.castLong(obj,0);
	}
	
	/**
	 * ת����int���ͣ���ָ��Ĭ��ֵ��
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
	 * ת����int����
	 * @param obj
	 * @return
	 */
	public static int castInt(Object obj){
		return CastUtil.castInt(obj, 0);
	}
	
	/**
	 * ת����double���ͣ���ָ��Ĭ��ֵ��
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
	 * ת����double����
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static double castDouble(Object obj){
		return CastUtil.castDouble(obj, 0);
	}
	
}

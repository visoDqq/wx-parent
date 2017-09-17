package com.wx.framework.partA.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.wx.framework.partA.utils.ReflectionUtil;

public class BeanHelper {

	
	/**
	 * 定义bean映射（用于存放bean类与bean实例的映射关系）
	 */
	private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>, Object>();
	
	static{
		Set<Class<?>> classSet = ClassHelper.getBeanClassSet();
		for (Class<?> cls : classSet) {
			Object instance = ReflectionUtil.newInstance(cls);
			BEAN_MAP.put(cls, instance);
		}
	}
	
	/**
	 * 获得bean映射
	 * @return
	 */
	public static Map<Class<?>, Object> getBeanMap(){
		return BEAN_MAP;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<?> cls){
		return  (T) BEAN_MAP.get(cls);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

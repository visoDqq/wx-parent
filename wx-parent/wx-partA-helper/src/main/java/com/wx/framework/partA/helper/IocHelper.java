package com.wx.framework.partA.helper;

import java.lang.reflect.Field;
import java.util.Map;

import com.wx.framework.partA.annotation.Inject;
import com.wx.framework.partA.utils.ReflectionUtil;

public class IocHelper {

	
	
	static{
		//获取所有bean类与bean实例之间的映射
		Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap(); 
		
		if (beanMap != null) {
			//遍历beanMap
			for(Map.Entry<Class<?>, Object> entry : beanMap.entrySet()){
				//从beanMap中获取bean类和bean实例
				Class<?> beanClass = entry.getKey();
				Object beanInstance = entry.getValue();
				//获取bean类定义的所有成员变量
				Field[] fields = beanClass.getFields();
				if (fields != null) {
					//遍历fields
					for (Field field : fields) {
						//判断成员变量是否带有inject注解
						if (field.isAnnotationPresent(Inject.class)) {
							Class<?> fieldBean = field.getType();
							if (beanMap.containsKey(fieldBean)) {
								//从beanMap中获取fields对应的实例
								Object fieldInstance = beanMap.get(fieldBean);
								if (fieldInstance != null) {
									//通过反射初始化field的值
									ReflectionUtil.setField(beanInstance, field, fieldInstance);
								}
							}
						}
					}
				}
			}
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		int[] a ={20,99,120,60,4,0,-1};
		int c;
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if (a[i] > a[j]) {
					c= a[j];
					a[j] = a[i];
					a[i] = c;
				}
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}

package com.wx.framework.partA.helper;

import java.lang.reflect.Field;
import java.util.Map;

import com.wx.framework.partA.annotation.Inject;
import com.wx.framework.partA.utils.ReflectionUtil;

public class IocHelper {

	
	
	static{
		Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
		
		if (beanMap != null) {
			for(Map.Entry<Class<?>, Object> entry : beanMap.entrySet()){
				Class<?> beanClass = entry.getKey();
				Object beanInstance = entry.getValue();
				Field[] fields = beanClass.getDeclaredFields();
				if (fields != null) {
					for (Field field : fields) {
						if (field.isAnnotationPresent(Inject.class)) {
							Class<?> fieldBean = field.getType();
							if (beanMap.containsKey(fieldBean)) {
								Object fieldInstance = beanMap.get(fieldBean);
								if (fieldInstance != null) {
									ReflectionUtil.setField(beanInstance, field, fieldInstance);
								}
							}
						}
					}
				}
			}
		}
		
		
	}

}

package com.wx.framework.partA.helper;

import java.lang.reflect.Field;
import java.util.Map;

import com.wx.framework.partA.annotation.Inject;
import com.wx.framework.partA.utils.ReflectionUtil;

public class IocHelper {

	
	
	static{
		//��ȡ����bean����beanʵ��֮���ӳ��
		Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap(); 
		
		if (beanMap != null) {
			//����beanMap
			for(Map.Entry<Class<?>, Object> entry : beanMap.entrySet()){
				//��beanMap�л�ȡbean���beanʵ��
				Class<?> beanClass = entry.getKey();
				Object beanInstance = entry.getValue();
				//��ȡbean�ඨ������г�Ա����
				Field[] fields = beanClass.getFields();
				if (fields != null) {
					//����fields
					for (Field field : fields) {
						//�жϳ�Ա�����Ƿ����injectע��
						if (field.isAnnotationPresent(Inject.class)) {
							Class<?> fieldBean = field.getType();
							if (beanMap.containsKey(fieldBean)) {
								//��beanMap�л�ȡfields��Ӧ��ʵ��
								Object fieldInstance = beanMap.get(fieldBean);
								if (fieldInstance != null) {
									//ͨ�������ʼ��field��ֵ
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

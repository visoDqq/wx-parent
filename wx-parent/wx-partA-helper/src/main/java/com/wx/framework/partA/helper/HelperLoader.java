package com.wx.framework.partA.helper;

import com.wx.framework.partA.utils.ClassUtil;


public class HelperLoader {
	
	
	public static void init(){
		Class<?>[] classList = {
				ClassHelper.class,
				BeanHelper.class,
				AopHelper.class,
				IocHelper.class,
				ControllerHelper.class
		};
		for (Class<?> cls : classList) {
			ClassUtil.loadClass(cls.getName());
		}
	}
}

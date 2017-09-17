package com.wx.framework.partA.helper;

import java.util.HashSet;
import java.util.Set;

import com.wx.framework.partA.annotation.Controller;
import com.wx.framework.partA.annotation.Service;
import com.wx.framework.partA.utils.ClassUtil;

public final class ClassHelper {

	private static final Set<Class<?>> CLASS_SET;
	
	static{
		String basePackage = ConfigHelper.getAppBasePackage();
		CLASS_SET = ClassUtil.getClassSet(basePackage);
	}
	
	/**
	 * 获取应用包名下所有类
	 * @return
	 */
	public static Set<Class<?>> getClassSet(){
		return CLASS_SET;
	}
	
	/**
	 * 获取应用包名下所有Service类
	 * @return
	 */
	public static Set<Class<?>> getServiceClassSet(){
		Set<Class<?>> classes = new HashSet<Class<?>>();
		for (Class<?> serviceClass : CLASS_SET) {
			if (serviceClass.isAnnotationPresent(Service.class)) {
				classes.add(serviceClass);
			}
		}
		return classes;
	}
	
	/**
	 * 获取应用包名下所有Controller类
	 * @return
	 */
	public static Set<Class<?>> getControllerClassSet(){
		Set<Class<?>> classes = new HashSet<Class<?>>();
		for (Class<?> serviceClass : CLASS_SET) {
			if (serviceClass.isAnnotationPresent(Controller.class)) {
				classes.add(serviceClass);
			}
		}
		return classes;
	}
	
	/**
	 * 获取应用包名下所有bean类
	 * @return
	 */
	public static Set<Class<?>> getBeanClassSet(){
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.addAll(getServiceClassSet());
		classes.addAll(getControllerClassSet());
		return classes;
	}
	
	/**
	 * 获取应用包名下所有继承自某个类的所有子类
	 * @param superClass
	 * @return
	 */
	public static Set<Class<?>> getClassSetbySuper(Class<?> superClass){
		Set<Class<?>> classes = new HashSet<Class<?>>();
		for (Class<?> clazz : CLASS_SET) {
			if(clazz.isAssignableFrom(superClass) && !clazz.equals(superClass)){
				classes.add(clazz);
			}
		}
		return classes;
	}
	
}

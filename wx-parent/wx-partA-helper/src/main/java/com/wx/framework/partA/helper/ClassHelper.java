package com.wx.framework.partA.helper;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

import com.wx.framework.partA.annotation.Controller;
import com.wx.framework.partA.annotation.Service;
import com.wx.framework.partA.proxy.AspectProxy;
import com.wx.framework.partA.utils.ClassUtil;

public final class ClassHelper {

	private static final Set<Class<?>> CLASS_SET;
	
	static{
		String basePackage = ConfigHelper.getAppBasePackage();
		CLASS_SET = ClassUtil.getClassSet(basePackage);
	}
	
	/**
	 * ��ȡӦ�ð�����������
	 * @return
	 */
	public static Set<Class<?>> getClassSet(){
		return CLASS_SET;
	}
	
	/**
	 * ��ȡӦ�ð���������Service��
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
	 * ��ȡӦ�ð���������Controller��
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
	 * ��ȡӦ�ð���������bean��
	 * @return
	 */
	public static Set<Class<?>> getBeanClassSet(){
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.addAll(getServiceClassSet());
		classes.addAll(getControllerClassSet());
		return classes;
	}
	
	/**
	 * ��ȡӦ�ð��������м̳���ĳ�������������
	 * @param superClass
	 * @return
	 */
	public static Set<Class<?>> getClassSetbySuper(Class<?> superClass){
		Set<Class<?>> classes = new HashSet<Class<?>>();
		for (Class<?> clazz : CLASS_SET) {
			if(superClass.isAssignableFrom(clazz) && !clazz.equals(superClass)){
				classes.add(clazz);
			}
		}
		return classes;
	}

	public static Set<Class<?>> getClassSetByAnnotation(Class<? extends Annotation> clazz){
		Set<Class<?>> classes = new HashSet<>();
		for (Class<?> cls : CLASS_SET){
			if (cls.isAnnotationPresent(clazz)){
				classes.add(cls);
			}
		}
		return classes;
	}

	public static void main(String[] args){
		Set<Class<?>> classes = getClassSetbySuper(AspectProxy.class);
		System.out.println(classes);
		System.out.println(CLASS_SET);
	}
}

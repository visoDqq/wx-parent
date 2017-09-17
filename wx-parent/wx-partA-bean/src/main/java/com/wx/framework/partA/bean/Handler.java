package com.wx.framework.partA.bean;

import java.lang.reflect.Method;

public class Handler {


	//������bean��
	private Class<?> controllerClass;
	//Action����
	private Method actionMethod;
	
	public Handler(Class<?> controllerClass, Method actionMethod) {
		this.controllerClass = controllerClass;
		this.actionMethod = actionMethod;
	}
	public Class<?> getControllerClass() {
		return controllerClass;
	}
	public Method getActionMethod() {
		return actionMethod;
	}
}

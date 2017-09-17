package com.wx.framework.partA.bean;

import java.util.HashMap;
import java.util.Map;

public class View {

	/**
	 * ��ͼ·��
	 */
	private String path;
	/**
	 * ģ������
	 */
	private Map<String, Object> model;
	
	public View(String path) {
		this.path = path;
		this.model = new HashMap<String, Object>();
	}
	
	public View addModel(String name, Object obj){
		this.model.put(name, obj);
		return this;
	}
	
	public String getPath() {
		return path;
	}
	public Map<String, Object> getModel() {
		return model;
	}
	
}

package com.wx.framework.partA.bean;

import java.util.Map;

import com.wx.framework.partA.utils.CastUtil;

public class Param {

	private Map<String, Object> paramMap;
	
	public Param(Map<String, Object> paramMap) {
		this.paramMap = paramMap;
	}
	
	public Map<String, Object> getParamMap() {
		return paramMap;
	}
	
	public long getLong(String name){
		return CastUtil.castLong(name);
	}
}

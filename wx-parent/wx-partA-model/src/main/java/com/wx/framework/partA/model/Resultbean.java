package com.wx.framework.partA.model;

public class Resultbean<T> {

	
	private int code = 10001;
	
	private String msg = "success";
	
	private T data;

	
	public Resultbean(T data) {
		super();
		this.data = data;
	}

	public Resultbean(int code, String msg, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}

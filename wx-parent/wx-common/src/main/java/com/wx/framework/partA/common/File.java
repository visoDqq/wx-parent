package com.wx.framework.partA.common;

public class File implements IFile{

	private String name;
	private int deep;
	
	public File(String name) {
		this.name = name;
	}

	@Override
	public IFile getComposite() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public void sampleOperation() {
		System.out.println("执行了某个方法");
		
	}

	@Override
	public int getDeep() {
		// TODO Auto-generated method stub
		return deep;
	}

	@Override
	public void setDeep(int x) {
		this.deep = x;
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

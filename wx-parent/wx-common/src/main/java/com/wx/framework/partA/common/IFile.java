package com.wx.framework.partA.common;

public interface IFile {
	//返回自己的实例
	public IFile getComposite();
	//某个商业方法
	public void sampleOperation();
	//获取深度
	public int getDeep();
	//设置深度
	public void setDeep(int x);
}

package com.wx.framework.partA.common;

import java.util.Vector;

public class Folder implements IFile{



	private Vector<IFile> folders;
	private String name;
	private int deep;
	
	public Folder(String name) {
		this.name = name;
		this.folders = new Vector<IFile>();
	}
	//增加一个文件或文件夹
	public void add(IFile file){
		folders.addElement(file);
		this.setDeep(this.deep+1);
	}
	//删除一个文件或文件夹
	public void remove(IFile file){
		folders.removeElement(file);
	}
	//返回直接子文件（夹）集合
	public Vector getAllElement(){
		return folders;
	}
	
	//返回自己的实例
	@Override
	public IFile getComposite() {
		return this;
	}
	//执行某个商业方法
	@Override
	public void sampleOperation() {
		System.out.println("执行了某个商业方法");
	}
	//获取深度
	@Override
	public int getDeep() {
		return deep;
	}
	//设置深度
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

package com.wx.framework.partA.utils.finalize;

public class Book {

	private boolean checkOut = true;
	char a;
	short c;
	static int ii=8;
	static int i ;
	byte b;
	long d;
	float e;
	double f;
	boolean g;
	
	static{
		i = 9;
	}
	
	public void checkIn(){
		this.checkOut = false;
	}
	
	@Override
	protected void finalize() throws Throwable {
//		super.finalize();
		if (checkOut) {
			System.out.println("error : checkOut");
		}
	}
	
	
}

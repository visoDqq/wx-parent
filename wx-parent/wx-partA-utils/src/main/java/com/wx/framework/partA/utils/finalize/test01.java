package com.wx.framework.partA.utils.finalize;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book = new Book();
		int aa;
		System.out.println(book.i);
		System.out.println(book.ii);
		System.out.println(book.a);
		System.out.println(book.b);
		System.out.println(book.c);
		System.out.println(book.d);
		System.out.println(book.e);
		System.out.println(book.f);
		System.out.println(book.g);
		
		
		Random random = new Random(50);
		int[] a = new int[random.nextInt(40)];
		for (int i = 0; i < a.length; i++) {
			a[i] = random.nextInt(300);
		}
		System.out.println(Arrays.toString(a));
		System.out.println(a.length);
		
		Object[] objects = new Object[]{new Integer(1),new Double(10),new Float(20)};
		printArray(objects);
		printArray2(objects);
		printArray2();
		objects = new Object[]{new test01(),new test01(),new test01()};
		printArray(objects);
		
		
		
	}

	public static void printArray(Object[] obj){
		for (Object object : obj) {
			System.out.print(object +" ");
		}
		System.out.println();
	}
	
	public static void printArray2(Object... args){
		for (Object object : args) {
			System.out.print(object +" ");
		}
		System.out.println();
	}
}

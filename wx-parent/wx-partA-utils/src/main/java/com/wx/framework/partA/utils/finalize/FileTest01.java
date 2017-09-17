package com.wx.framework.partA.utils.finalize;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		read5();
		
	}
	
	
	
	
	public static void writeIt(){
		File f = null;
		File fo = null;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		byte[] b = null;
		try {
			f = new File("D:\\file\\my.txt");
			fo = new File("D:\\file","myDuplication.java");
			fis = new FileInputStream(f);
			fos = new FileOutputStream(fo);
			b = new byte[(int)f.length()];
			if (f.isFile()) {
				fis.read(b);
				fos.write(b);
			}
			fos.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void read1(){
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		int n;
		
		isr = new InputStreamReader(System.in);
		osw = new OutputStreamWriter(System.out);
		
		try {
			while((n = isr.read()) != '\r'){
				osw.write(n);
			}
			osw.close();
			isr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void read2(){
		File f = null;
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		int n;
		
		try {
			
			f = new File("D:\\file\\my.txt");
			isr = new InputStreamReader(new FileInputStream(f));
			osw = new OutputStreamWriter(System.out);
			
			while ((n=isr.read()) != '\r') {
				osw.write(n);
			}
			osw.close();
			isr.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void read3(){
		BufferedReader br = null;
		InputStreamReader isr = null;
		
		isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);
		String line = "";
		String article = "";
		try {
			System.out.println("请输入字符串，并以end结束：");
			while (!(line = br.readLine()).equals("end")) {
				article = article + line + "\n"; 
			}
			System.out.println(article);
			br.close();
			isr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void read4(){
		BufferedReader br = null;
		BufferedWriter bw = null;
		File f = null;
		String line = "";
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			f = new File("D:\\file", "myname.java");
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
			while (!(line = br.readLine()).equals("end")) {
				bw.write(line);
				bw.newLine();
			}
			bw.close();
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void read5(){
		BufferedReader br = null;
		BufferedWriter bw = null;
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		File f = null;
		File fo = null;
		String line = "";
		
		try {
			f = new File("D:\\file\\my.txt");
			isr = new InputStreamReader(new FileInputStream(f));
			br = new BufferedReader(isr);
			fo = new File("D:\\file","my2.txt");
			osw = new OutputStreamWriter(new FileOutputStream(fo));
			bw = new BufferedWriter(osw);
			while(!(line = br.readLine()).equals("end")){
				bw.write(line);
				bw.newLine();
			}
			bw.close();
			osw.close();
			br.close();
			isr.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
	
	
	
}

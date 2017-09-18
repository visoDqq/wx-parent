package com.wx.framework.partA.utils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ClassUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Class<?>> set = getClassSet("com.wx.framework.partA");
		for (Iterator<Class<?>> it = set.iterator();it.hasNext(); ) {
			System.out.println(it.next());
		}
	}
	
	public static ClassLoader getClassLoader(){
		return Thread.currentThread().getContextClassLoader();
	}

	public static Class<?> loadClass(String packageName){
		Class<?> classes = null;
		try {
			classes = Class.forName(packageName);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classes;
	}
	
	
	public static Set<Class<?>> getClassSet(String packageName){
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		
		Enumeration<URL> urls = null;
		URL url = null;
		String protocol = null;
		String filePath = null;
		try {
			urls = getClassLoader().getResources(packageName.replace(".", "/"));
			if (urls != null) {
				while (urls.hasMoreElements()) {
					url = urls.nextElement();
					protocol = url.getProtocol();
					if ("file".equals(protocol)) {
						filePath = URLDecoder.decode(url.getPath().replaceAll("%20", " "),"utf-8");
						addClass(filePath,classSet,packageName);
					}else if ("jar".equals(protocol)){
						JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
						if (jarURLConnection != null){
							JarFile jarFile = jarURLConnection.getJarFile();
							if (jarFile != null){
								Enumeration<JarEntry> jarEntrys = jarFile.entries();
								while (jarEntrys.hasMoreElements()){
									JarEntry jarEntry = jarEntrys.nextElement();
									String jarName = jarEntry.getName();
									if (jarName.endsWith(".class")){
										String className = jarName.substring(0,jarName.lastIndexOf(".")).replaceAll("/",".");
										doAddClass(className,classSet);
									}
								}
							}
						}
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return classSet;
		
	}
	
	
	public static void addClass(String filePath, Set<Class<?>> classSet, String packageName){
		
		File[] files = new File(filePath).listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File file) {
				return (file.isDirectory() || (file.isFile() && file.getName().endsWith(".class")));
			}
		});
		
		for (File file : files) {
			String fileName = file.getName();
			if (file.isFile()) {
				
				String className = fileName.substring(0, fileName.indexOf("."));
				
				
				if (packageName != null) {
					className = packageName + "." + className;
				}
				doAddClass(className, classSet);
			}else {
				
				String subFilePath = fileName;
				if (filePath != null) {
					subFilePath = filePath + "/" + subFilePath;
				}
				String subPackageName = fileName;
				if (packageName != null) {
					subPackageName = packageName + "." + subPackageName;
				}
				addClass(subFilePath, classSet, subPackageName);
			}
		}
	}
	
	
	public static void doAddClass(String packageName,Set<Class<?>> classSet){
		Class<?> classes = loadClass(packageName);
		classSet.add(classes);
	}
	
	
	
	
}

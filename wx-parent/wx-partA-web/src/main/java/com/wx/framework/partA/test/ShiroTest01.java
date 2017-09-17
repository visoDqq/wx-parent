package com.wx.framework.partA.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroTest01 {

	private static final Logger logger = LoggerFactory.getLogger(ShiroTest01.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("shiro", "1314");
		
		subject.login(token);
		
		logger.info("µÇÂ¼³É¹¦ hello " + subject.getPrincipal());
		
		subject.logout();
		
		logger.info("1"+subject.getPrincipal());
	}

}

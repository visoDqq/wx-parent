package com.wx.framework.partA.helper;

import java.util.Properties;

import com.wx.framework.partA.common.constants.ConfigConstant;
import com.wx.framework.partA.utils.PropsUtil;



public final class ConfigHelper {

	public static final Properties CONFIG_PROPS = PropsUtil.propLoads(ConfigConstant.CONFIG_FILE);
	
	
	public static String getAppBasePackage(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_BASE_PACKAGE);
	}
	
	public static String getAppJspPath(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_JSP_BASE_PATH);
	}
	
	public static String getAppAssetPath(){
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_ASSET_PATH);
	}
}

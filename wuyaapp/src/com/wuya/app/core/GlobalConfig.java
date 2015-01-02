package com.wuya.app.core;

/**
 * 保存在程序运行过程中很少发生变化的全局变量
 * 
 */
public class GlobalConfig {

	private static MyApplication myApplication;
	
	private static String appVersionName;

	private GlobalConfig() {
	}

	public static MyApplication getMyApplication() {
		return myApplication;
	}

	public static void setMyApplication(MyApplication myApplication) {
		GlobalConfig.myApplication = myApplication;
	}

	public static void setAppVersion(String appVersionName) {
		GlobalConfig.setAppVersionName(appVersionName);
	}

	public static String getAppVersionName() {
		return appVersionName;
	}

	public static void setAppVersionName(String appVersionName) {
		GlobalConfig.appVersionName = appVersionName;
	}

}

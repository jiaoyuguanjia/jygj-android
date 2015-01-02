package com.wuya.app.core;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

public class MyApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		initConfig();

	}

	private void initConfig() {
		GlobalConfig.setMyApplication(this);
		GlobalConfig.setAppVersion(getAppVersionName());
	}

	private String getAppVersionName() {
		String appVerName = "";
		try {
			PackageManager pm = getPackageManager();
			PackageInfo pi = pm.getPackageInfo(getPackageName(), 0);
			if (!TextUtils.isEmpty(pi.versionName)) {
				appVerName = pi.versionName;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appVerName;
	}

}

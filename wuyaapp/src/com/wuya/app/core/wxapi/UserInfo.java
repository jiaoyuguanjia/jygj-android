package com.wuya.app.core.wxapi;

import android.content.Intent;
import android.text.TextUtils;

import com.wuya.app.EntranceActivity;
import com.wuya.app.LoginActivity;
import com.wuya.app.core.GlobalConfig;
import com.wuya.app.core.se.AESUtils;
import com.wuya.app.core.se.Base64Encoder;

public class UserInfo {

	public UserInfo() {
	}

	public static boolean isLogin() {
		return !TextUtils.isEmpty(getUserToken());
	}

	public static void login(String userType) {
		Intent intent = new Intent();
		intent.putExtra("userType", userType);
		intent.setClass(GlobalConfig.getMyApplication(), LoginActivity.class);
		GlobalConfig.getMyApplication().startActivity(intent);
	}

	public static String getUserId() {
		return SpManager.getInstance().getString(Const.LOGIN_USER_ID);
	}

	public void setUserId(String userId) {
		SpManager.getInstance().putString(Const.LOGIN_USER_ID, userId);
	}

	public static String getUserToken() {
		return SpManager.getInstance().getString(Const.LOGIN_USER_TOKEN);
	}

	public void setUserToken(String userToken) {
		SpManager.getInstance().putString(Const.LOGIN_USER_TOKEN,
				AESUtils.encrypt(userToken));
	}

	// 用户名
	public static String getUsername() {
		return SpManager.getInstance().getString(Const.LOGIN_USERNAME);
	}

	public void setUsername(String username) {
		SpManager.getInstance().putString(Const.LOGIN_USERNAME, username);
	}

	// 密码
	public static String getPassword() {
		return SpManager.getInstance().getString(Const.LOGIN_PASSWORD);
	}

	public void setPassword(String password) {
		if (password == null) {
			password = "";
		}
		SpManager.getInstance().putString(
				Const.LOGIN_PASSWORD,
				Base64Encoder.encodeToString(password.getBytes(),
						Base64Encoder.DEFAULT));
	}

	public static String getUserIcon() {
		return SpManager.getInstance().getString(Const.LOGIN_USER_ICON);
	}

	public void setUserIcon(String userIcon) {
		SpManager.getInstance().putString(Const.LOGIN_USER_ICON, userIcon);
	}

	public static String getUserType() {
		return SpManager.getInstance().getString(Const.LOGIN_USER_TYPE);
	}

	public void setUserType(String userType) {
		SpManager.getInstance().putString(Const.LOGIN_USER_TYPE, userType);
	}

}

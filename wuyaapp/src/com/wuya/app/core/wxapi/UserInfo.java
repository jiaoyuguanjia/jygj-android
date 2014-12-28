package com.wuya.app.core.wxapi;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.wuya.app.LoginActivity;
import com.wuya.app.core.se.AESUtils;
import com.wuya.app.core.se.Base64Encoder;

public class UserInfo {

	private Context context;
	private SharedPreferencesHelper spHelper;

	public UserInfo(Context context) {
		this.context = context;
		this.spHelper = new SharedPreferencesHelper(context);
	}

	public boolean isLogin() {
		return !TextUtils.isEmpty(getUserToken());
	}

	public void login(String userType) {
		Intent intent = new Intent();
		intent.putExtra("userType", userType);
		intent.setClass(context, LoginActivity.class);
		context.startActivity(intent);
	}

	public String getUserId() {
		return spHelper.getString(Const.LOGIN_USER_ID);
	}

	public void setUserId(String userId) {
		spHelper.putString(Const.LOGIN_USER_ID, userId);
	}

	public String getUserToken() {
		return spHelper.getString(Const.LOGIN_USER_TOKEN);
	}

	public void setUserToken(String userToken) {
		spHelper.putString(Const.LOGIN_USER_TOKEN, AESUtils.encrypt(userToken));
	}

	// 用户名
	public String getUsername() {
		return spHelper.getString(Const.LOGIN_USERNAME);
	}

	public void setUsername(String username) {
		spHelper.putString(Const.LOGIN_USERNAME, username);
	}

	// 密码
	public String getPassword() {
		return spHelper.getString(Const.LOGIN_PASSWORD);
	}

	public void setPassword(String password) {
		if (password == null) {
			password = "";
		}
		spHelper.putString(Const.LOGIN_PASSWORD, Base64Encoder.encodeToString(
				password.getBytes(), Base64Encoder.DEFAULT));
	}

	public String getUserIcon() {
		return spHelper.getString(Const.LOGIN_USER_ICON);
	}

	public void setuserIcon(String userIcon) {
		spHelper.putString(Const.LOGIN_USER_ICON, userIcon);
	}

	public String getUserType() {
		return spHelper.getString(Const.LOGIN_USER_TYPE);
	}

	public void setUserType(String userType) {
		spHelper.putString(Const.LOGIN_USER_TYPE, userType);
	}

}

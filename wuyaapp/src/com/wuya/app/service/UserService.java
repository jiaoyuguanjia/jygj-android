package com.wuya.app.service;

import java.util.Map;

import org.json.JSONObject;

import android.content.Context;
import android.text.TextUtils;

import com.wuya.app.core.net.ApiConst;
import com.wuya.app.core.net.HttpClientUtils;
import com.wuya.app.core.wxapi.UserInfo;

public class UserService {
	
	private Context context;
	
	public UserService(Context context) {
		this.context = context;
	}
	
	public boolean checkLogin(Map<String, String> params) {
		//调用服务器登录校验
		try {
			JSONObject jsonObject = HttpClientUtils.post(ApiConst.LOGIN_API_URL, params);
			if (jsonObject == null) {
				return false;
			}
			if (!TextUtils.equals(jsonObject.getString("success"), "SUCCESS")) {
				return false;
			}
			//TODO: 将返回的用户信息保存到本地缓存起来
			UserInfo userInfo = new UserInfo(context);
			userInfo.setUserId(jsonObject.getString("userId"));
			userInfo.setUserToken(jsonObject.getString("userToken"));
			userInfo.setUsername(jsonObject.getString("username"));
			userInfo.setPassword(jsonObject.getString("password"));
			userInfo.setuserIcon(jsonObject.getString("userIcon"));
			userInfo.setUserType(jsonObject.getString("userType"));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}

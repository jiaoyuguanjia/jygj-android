package com.wuya.app;

import android.app.Activity;
import android.os.Bundle;

/**
 * 老师，学生登录的Activity
 * 
 * @author xiaocilin
 * 
 * @since 2014-11-30
 * 
 */
public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);	
		
		this.setTitle("登录");
	}

	
}

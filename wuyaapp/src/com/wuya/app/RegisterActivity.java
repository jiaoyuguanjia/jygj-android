package com.wuya.app;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

/**
 * Created by shengwei on 2014/11/22.
 */
public class RegisterActivity extends Activity {
	
	private static String registerType;
	
	private TextView registerTipsTv;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        
        registerTipsTv = (TextView) this.findViewById(R.id.register_tips);
        registerType = getIntent().getStringExtra("registerType");
        if (TextUtils.equals(registerType, "student")) {
        	this.setTitle("学生注册");
        	registerTipsTv.setText("3秒快速注册：");
        } else {
        	this.setTitle("老师注册");
        	registerTipsTv.setText("手机注册：");
        }
    }
}
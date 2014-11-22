package com.wuya.app;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by shengwei on 2014/11/22.
 */
public class RegisterActivity extends Activity {
	
	private static String registerType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        
        registerType = getIntent().getStringExtra("registerType");
    }
}
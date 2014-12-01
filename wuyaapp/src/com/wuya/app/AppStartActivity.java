package com.wuya.app;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * 应用启动页
 * 
 * @author xiaocilin
 * 
 * @since 2014-11-22
 * 
 */
public class AppStartActivity extends Activity {

	/**
	 * 下一个要跳转的意图
	 */
	private Intent intent;
	
	private boolean isLogin = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_app_start);

		Timer timer = new Timer();
		TimerTask tast = new TimerTask() {
			@Override
			public void run() {
				//TODO:如果用户已经登录，直接跳转到首页
				if (isLogin) {
					intent = new Intent(AppStartActivity.this, HomeFragment.class);
				} else {
					intent = new Intent(AppStartActivity.this, EntranceActivity.class);
				}
				startActivity(intent);
			}
		};
		timer.schedule(tast, 1000);
	}
}

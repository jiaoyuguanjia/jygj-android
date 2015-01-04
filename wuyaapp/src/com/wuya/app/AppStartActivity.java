package com.wuya.app;

import java.util.Timer;
import java.util.TimerTask;

import com.wuya.app.core.wxapi.Const;
import com.wuya.app.core.wxapi.SpManager;

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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Boolean isFirstUse = SpManager.getInstance().getBoolean(Const.ACTIVITY_GUIDE);
		if (!isFirstUse) {
			intent = new Intent(AppStartActivity.this, GuideActivity.class);
			startActivity(intent);
			finish();
		} else {
			setContentView(R.layout.activity_app_start);

			Timer timer = new Timer();
			TimerTask tast = new TimerTask() {
				@Override
				public void run() {
					intent = new Intent(AppStartActivity.this, MainActivity.class);
					startActivity(intent);
					finish();
				}
			};
			timer.schedule(tast, 1000);
		}
		
	}
}

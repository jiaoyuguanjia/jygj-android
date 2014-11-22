package com.wuya.app;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		/** 全屏设置，隐藏窗口所有装饰 */
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		/** 标题是属于View的，所以窗口所有的修饰部分被隐藏后标题依然有效 */
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_main);

		final Intent entranceIntent = new Intent(this, EntranceActivity.class);
		Timer timer = new Timer();
		TimerTask tast = new TimerTask() {
			@Override
			public void run() {
				startActivity(entranceIntent);
			}
		};
		timer.schedule(tast, 3000);
	}
}

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
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		final Intent intent = new Intent(this, EntranceActivity.class);
		Timer timer = new Timer();
		TimerTask tast = new TimerTask() {
			@Override
			public void run() {
				startActivity(intent);
			}
		};
		timer.schedule(tast, 3000);
	}
}

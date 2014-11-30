package com.wuya.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * 登录，注册的入口页
 * 
 * @author xiaocilin
 * 
 * @since 20140-11-22
 * 
 */
public class EntranceActivity extends Activity implements OnClickListener {

	/*学生注册*/
	private Button stuRegisterBtn;
	
	/*老师注册*/
	private Button tutorRegisterBtn;

	/*登录*/
	private Button loginBtn;
	
	private TextView justLookingTv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_entrance);	

		stuRegisterBtn = (Button) this.findViewById(R.id.student_register);
		tutorRegisterBtn = (Button) this.findViewById(R.id.tutor_register);
		loginBtn = (Button) this.findViewById(R.id.login);
		justLookingTv = (TextView) this.findViewById(R.id.just_looking);
		
		stuRegisterBtn.setOnClickListener(this);
		tutorRegisterBtn.setOnClickListener(this);
		loginBtn.setOnClickListener(this);
		justLookingTv.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.student_register:
			Intent stuIntent = new Intent(this, RegisterActivity.class);
			stuIntent.putExtra("registerType", "student");
			startActivity(stuIntent);
			break;
		case R.id.tutor_register:
			Intent tutorIntent = new Intent(this, RegisterActivity.class);
			tutorIntent.putExtra("registerType", "tutor");
			startActivity(tutorIntent);
			break;
		case R.id.login:
			startActivity(new Intent(this, LoginActivity.class));
			break;
		case R.id.just_looking:
			startActivity(new Intent(this, HomeActivity.class));
			break;
		default:
			break;
		}
	}
}

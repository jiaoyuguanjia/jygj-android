package com.wuya.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 登录，注册的入口页
 * 
 * @author xiaocilin
 * 
 * @since 20140-11-22
 * 
 */
public class EntranceActivity extends Activity implements OnClickListener {

	private Button stuRegisterBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_entrance);	
		
		stuRegisterBtn = (Button) this.findViewById(R.id.student_register);
		stuRegisterBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.student_register:
			startActivity(new Intent(this, StudentRegisterActivity.class));
			break;
		case R.id.tutor_register:
			break;
		case R.id.login:
			break;
		default:
			break;
		}
		
	}
}

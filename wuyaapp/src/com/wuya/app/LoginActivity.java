package com.wuya.app;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wuya.app.service.UserService;

/**
 * 老师，学生登录的Activity
 * 
 * @author xiaocilin
 * 
 * @since 2014-11-30
 * 
 */
public class LoginActivity extends Activity implements OnClickListener {
	
	private EditText loginPhoneEt;
	
	private EditText loginPasswordEt;
	
	private Button loginBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);	
		this.setTitle("登录");
		
		loginPhoneEt = (EditText) this.findViewById(R.id.id_login_phone);
		loginPasswordEt = (EditText) this.findViewById(R.id.id_login_password);
		
		loginBtn = (Button) this.findViewById(R.id.id_login_btn);
		loginBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.id_login_btn) {
			String loginPhone = loginPhoneEt.getText().toString().trim();
			String loginPassword = loginPasswordEt.getText().toString().trim();
			if (!validate(loginPhone, loginPassword)) {
				return;
			}
			Map<String, String> params = new HashMap<String, String>();
			params.put("username", loginPhone);
			params.put("password", loginPassword);
			new UserService(LoginActivity.this).checkLogin(params);
		}
	}

	private boolean validate(String loginPhone, String loginPassword) {
		//登录元素校验
		if (TextUtils.isEmpty(loginPhone)) {
			Toast.makeText(LoginActivity.this, "请输入登录手机号!", Toast.LENGTH_SHORT).show();
			return false;
		}
		if (!TextUtils.isDigitsOnly(loginPhone)) {
			Toast.makeText(LoginActivity.this, "请输入正确的登录手机号!", Toast.LENGTH_SHORT).show();
			return false;
		}
		if (TextUtils.isEmpty(loginPassword)) {
			Toast.makeText(LoginActivity.this, "请输入登录密码!", Toast.LENGTH_SHORT).show();
			return false;
		}
		return true;
	}

	
}

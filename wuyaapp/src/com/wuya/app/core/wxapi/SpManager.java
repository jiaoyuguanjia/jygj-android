package com.wuya.app.core.wxapi;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.wuya.app.core.GlobalConfig;

public class SpManager {

	private SharedPreferences sp;
	
	private static SpManager instance;
	
	private static Object lock = new Object();

	public SpManager(Context context) {
		this.sp = context.getSharedPreferences(Const.STORE_NAME, Context.MODE_PRIVATE);
	}
	
	public static SpManager getInstance() {
		if (instance == null) {
			synchronized (lock) {
				if (instance == null) {
					instance = new SpManager(GlobalConfig.getMyApplication());
				}
			}
		}
		return instance;
	}
	
	/**
	 * 
	 * @param valueParams
	 *            保存的Map对象
	 */
	public void save(HashMap<String, String> valueParams) {
		Editor editor = sp.edit();// 得到一个SP的编辑器
		for (Map.Entry<String, String> entry : valueParams.entrySet()) {
			editor.putString(entry.getKey(), entry.getValue());
		}
		editor.commit();// 执行commit操作才会将数据保存到的文件，保证数据同时提交成功
	}

	public Map<String, ?> readAll() {
		return sp.getAll();
	}

	public void putString(String key, String value) {
		sp.edit().putString(key, value).commit();
	}

	public String getString(String key) {
		return sp.getString(key, "");
	}
}

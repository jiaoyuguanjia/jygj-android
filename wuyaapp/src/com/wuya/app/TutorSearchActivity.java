package com.wuya.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.wuya.app.service.TutorApi;

/**
 * 根据课程搜索老师列表页
 * 
 * @author xiaocilin
 * 
 * @since 2015-1-2
 * 
 */
public class TutorSearchActivity extends Activity {
	
	private ListView tutorsLv;
	
	private List<Map<String, Object>> tutorVoMapList = new ArrayList<Map<String, Object>>();
	private TutorApi tutorApi = new TutorApi();
	
	private SimpleAdapter tutorAdapter;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tutor_search);
		
		tutorsLv = (ListView) findViewById(R.id.tutor_list_lv);
		try {
			tutorVoMapList = tutorApi.getNewlyTutorMapList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String[] from = new String[]{"alias", "profile", "teachingAge"};
		int[] to = new int[]{R.id.tutor_name_tv, R.id.tutor_profile_tv, R.id.edu_age_tv};
		tutorAdapter = new SimpleAdapter(this, tutorVoMapList, R.layout.tutor_item, from, to);

		tutorsLv.setAdapter(tutorAdapter);
	}

}

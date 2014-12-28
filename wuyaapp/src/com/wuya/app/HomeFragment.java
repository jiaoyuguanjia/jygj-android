package com.wuya.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.wuya.app.adapter.CategoryExpandableListAdapter;
import com.wuya.app.api.CategoryApi;
import com.wuya.app.api.TutorApi;
import com.wuya.app.vo.CategoryVO;

/**
 * 首页的窗口
 * 
 * @author xiaocilin
 * 
 * @since 2014-11-30
 * 
 */
public class HomeFragment extends Fragment implements OnGroupExpandListener {

	private List<List<CategoryVO>> categoryVosList = new ArrayList<List<CategoryVO>>();
	
	private List<Map<String, Object>> tutorVoMapList = new ArrayList<Map<String, Object>>();

	private ExpandableListView categoryLv;
	
	private ListView newTutorLv;
	
	private CategoryExpandableListAdapter categoryAdapter;
	
	private SimpleAdapter newlyTutorAdapter;
	
	private CategoryApi categoryApi = new CategoryApi();
	
	private TutorApi tutorApi = new TutorApi();
	

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View homeLayout = inflater.inflate(R.layout.home_fragment, container, false);

		categoryLv = (ExpandableListView) homeLayout.findViewById(R.id.category_lv);
		categoryLv.setGroupIndicator(null);//去掉默认箭头
		newTutorLv = (ListView) homeLayout.findViewById(R.id.newly_tutor_list);
		
		categoryVosList = categoryApi.getCategoryVosList();
		categoryAdapter = new CategoryExpandableListAdapter(getActivity().getApplicationContext(), categoryLv, categoryVosList);
		categoryLv.setAdapter(categoryAdapter);
		categoryLv.setOnGroupExpandListener(this);
		
		
		try {
			tutorVoMapList = tutorApi.getNewlyTutorMapList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String[] from = new String[]{"alias", "profile", "teachingAge"};
		int[] to = new int[]{R.id.tutor_name_tv, R.id.tutor_profile_tv, R.id.edu_age_tv};
		newlyTutorAdapter = new SimpleAdapter(getActivity().getApplicationContext(), tutorVoMapList, R.layout.newly_tutor_item, from, to);
		
		newTutorLv.setAdapter(newlyTutorAdapter);
		
	
		return homeLayout;
	}

	@Override
	public void onGroupExpand(int groupPosition) {
		for (int i = 0; i < categoryAdapter.getGroupCount(); i++) {
			if (groupPosition != i && categoryLv.isGroupExpanded(groupPosition)) {
				categoryLv.collapseGroup(i);
			}
		}
	}
	
}

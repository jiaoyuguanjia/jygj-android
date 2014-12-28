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
import com.wuya.app.vo.TutorVo;

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
	
	private List<TutorVo> tutorVoList = new ArrayList<TutorVo>();

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
		tutorVoList = tutorApi.getNewlyTutorList();
		
		
		categoryAdapter = new CategoryExpandableListAdapter(getActivity().getApplicationContext(), categoryLv, categoryVosList);
		
		List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		String[] from = new String[]{};
		int[] to = new int[]{};
		newlyTutorAdapter = new SimpleAdapter(getActivity().getApplicationContext(), data, R.layout.newly_tutor_item, from, to);
		
		categoryLv.setAdapter(categoryAdapter);
		
		categoryLv.setOnGroupExpandListener(this);
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

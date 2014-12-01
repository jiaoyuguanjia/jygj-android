package com.wuya.app;

import java.util.ArrayList;
import java.util.List;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.wuya.app.vo.CategoryVo;

/**
 * 首页的窗口
 * 
 * @author xiaocilin
 * 
 * @since 2014-11-30
 * 
 */
public class HomeFragment extends Fragment implements OnItemClickListener{

	private GridView gridview;

	private List<CategoryVo> categoryList;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		//super.onCreate(savedInstanceState);
		//setContentView(R.layout.home_layout);
		View homeLayout = inflater.inflate(R.layout.home_layout,
				container, false);
		gridview = (GridView) homeLayout.findViewById(R.id.category_gridview);

		categoryList = mockList();
		// 添加并且显示
		gridview.setAdapter(new CategoryListAdapter());
		// 添加消息处理
		gridview.setOnItemClickListener(this);
		return homeLayout;
	}

	private List<CategoryVo> mockList() {
		List<CategoryVo> categoryList = new ArrayList<CategoryVo>();
		categoryList.add(new CategoryVo(1, "小学", "#86BA75"));
		categoryList.add(new CategoryVo(2, "初中", "#4EA8C7"));
		categoryList.add(new CategoryVo(3, "高中", "#D9A24D"));
		categoryList.add(new CategoryVo(4, "学前教育", "#E26A68"));
		categoryList.add(new CategoryVo(5, "大学", "#D9792B"));
		categoryList.add(new CategoryVo(6, "出国留学", "#51B1A3"));
		categoryList.add(new CategoryVo(7, "艺术体育", "#7383C0"));
		categoryList.add(new CategoryVo(8, "生活技能", "#6BA74E"));
		categoryList.add(new CategoryVo(9, "语言培训", "#DE6444"));

		return categoryList;
	}

	// 当AdapterView被单击(触摸屏或者键盘)，则返回的Item单击事件
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		CategoryVo item = (CategoryVo) arg0.getItemAtPosition(arg2);
		getActivity().setTitle(item.getName());

	}

	private class CategoryListAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return categoryList.size();
		}

		@Override
		public Object getItem(int position) {
			return categoryList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return categoryList.get(position).getId();
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			CategoryVo category = categoryList.get(position);
			// context 上下文对象
			// resource 将那个资源用于充气，意思就是将数据填充到那个布局资源文件中
			// root 气球挂靠在那个父容器中，如果没有，则null
			View view = View.inflate(getActivity().getApplicationContext(),
					R.layout.activity_home_category_item, null);

			TextView tvCategoryName = (TextView) view
					.findViewById(R.id.tv_category_name);
			tvCategoryName.setText(category.getName());
			tvCategoryName.setTextColor(Color.parseColor(category.getColor()));

			return view;
		}
	}

}

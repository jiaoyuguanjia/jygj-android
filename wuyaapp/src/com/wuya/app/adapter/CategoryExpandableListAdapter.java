package com.wuya.app.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wuya.app.R;
import com.wuya.app.vo.CategoryVO;

/**
 * 教育分类的数据适配器
 * 
 * @author xiaocilin
 * 
 */
public class CategoryExpandableListAdapter extends BaseExpandableListAdapter {

	private Context context;

	private List<List<CategoryVO>> categoryList;

	private ExpandableListView categoryLv;

	private int clickPosition = -1;
	private int clickGroup = -1;

	public CategoryExpandableListAdapter(Context context,
			ExpandableListView categoryLv, List<List<CategoryVO>> categoryList) {
		this.context = context;
		this.categoryLv = categoryLv;
		this.categoryList = categoryList;
	}

	@Override
	public int getGroupCount() {
		return categoryList.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return 1;
	}

	@Override
	public Object getGroup(int groupPosition) {
		return categoryList.get(groupPosition);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return categoryList.get(groupPosition).get(childPosition);
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null || convertView.getTag() == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null);
			holder = new ViewHolder();
			holder.first = (TextView) convertView.findViewById(R.id.first_tv);
			holder.second = (TextView) convertView.findViewById(R.id.second_tv);
			holder.third = (TextView) convertView.findViewById(R.id.third_tv);

			holder.firstIv = (ImageView) convertView.findViewById(R.id.first_iv);
			holder.secondIv = (ImageView) convertView.findViewById(R.id.second_iv);
			holder.thirdIv = (ImageView) convertView.findViewById(R.id.third_iv);
			holder.firstLinear = (LinearLayout) convertView.findViewById(R.id.first_linear);
			holder.secondLinear = (LinearLayout) convertView.findViewById(R.id.second_linear);
			holder.thirdLinear = (LinearLayout) convertView.findViewById(R.id.third_linear);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		List<CategoryVO> groups = categoryList.get(groupPosition);
		boolean showSecond = false;
		boolean showThird = false;
		if (groups.size() == 2) {
			showSecond = true;
		} else if (groups.size() == 3) {
			showSecond = true;
			showThird = true;
		}
		CategoryVO firstCV = groups.get(0);
		holder.first.setText(firstCV.getName());
		holder.first.setTextColor(Color.parseColor(firstCV.getColor()));
		if (showSecond) {
			holder.secondLinear.setVisibility(View.VISIBLE);
			CategoryVO secondCV = groups.get(1);
			holder.second.setText(secondCV.getName());
			holder.second.setTextColor(Color.parseColor(secondCV.getColor()));
		} else {
			holder.secondLinear.setVisibility(View.INVISIBLE);
		}

		if (showThird) {
			holder.thirdLinear.setVisibility(View.VISIBLE);
			CategoryVO thirdCV = groups.get(2);
			holder.third.setText(thirdCV.getName());
			holder.third.setTextColor(Color.parseColor(thirdCV.getColor()));
		} else {
			holder.thirdLinear.setVisibility(View.INVISIBLE);
		}
		View.OnClickListener listener = new View.OnClickListener() {
			public void onClick(View v) {
				switch (v.getId()) {
				case R.id.first_linear:
					if (categoryLv.isGroupExpanded(groupPosition)) {
						categoryLv.collapseGroup(groupPosition);
					}
					if (!(clickPosition == 0 && clickGroup == groupPosition)) {
						categoryLv.expandGroup(groupPosition);
						clickPosition = 0;
						clickGroup = groupPosition;
					} else {
						clickPosition = -1;
						clickGroup = -1;
					}
					break;
				case R.id.second_linear:
					if (categoryLv.isGroupExpanded(groupPosition)) {
						categoryLv.collapseGroup(groupPosition);
					}
					if (!(clickPosition == 1 && clickGroup == groupPosition)) {
						categoryLv.expandGroup(groupPosition);
						clickPosition = 1;
						clickGroup = groupPosition;
					} else {
						clickPosition = -1;
						clickGroup = -1;
					}

					break;
				case R.id.third_linear:
					if (categoryLv.isGroupExpanded(groupPosition)) {
						categoryLv.collapseGroup(groupPosition);
					}
					if (!(clickPosition == 2 && clickGroup == groupPosition)) {
						categoryLv.expandGroup(groupPosition);
						clickPosition = 2;
						clickGroup = groupPosition;
					} else {
						clickPosition = -1;
						clickGroup = -1;
					}
					break;
				default:
					break;
				}
				categoryLv.post(new Runnable() {

					@Override
					public void run() {
						categoryLv.setSelection(groupPosition);
					}
				});
			}
		};
		holder.firstLinear.setOnClickListener(listener);
		holder.secondLinear.setOnClickListener(listener);
		holder.thirdLinear.setOnClickListener(listener);

		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		convertView = LayoutInflater.from(context).inflate(R.layout.category_first_child, null);
		ImageView left = (ImageView) convertView.findViewById(R.id.type_left_arror);
		ImageView middle = (ImageView) convertView.findViewById(R.id.type_middle_arror);
		ImageView right = (ImageView) convertView.findViewById(R.id.type_right_arror);
		LinearLayout typesLayout = (LinearLayout) convertView.findViewById(R.id.types_layout);

		CategoryVO vo = categoryList.get(groupPosition).get(clickPosition);
		left.setVisibility(View.GONE);
		middle.setVisibility(View.GONE);
		right.setVisibility(View.GONE);
		switch (clickPosition) {
		case 0:
			left.setVisibility(View.VISIBLE);
			break;
		case 1:
			middle.setVisibility(View.VISIBLE);
			break;
		case 2:
			right.setVisibility(View.VISIBLE);
			break;
		default:
			break;
		}

		List<CategoryVO> childs = vo.getSubcategoryList();
		LinearLayout childLayout = (LinearLayout) LayoutInflater.from(context)
				.inflate(R.layout.category_second_child, null);
		for (int i = 0; i < childs.size(); i++) {
			final CategoryVO second = childs.get(i);
			switch ((i + 1) % 3) {
			case 0:
				TextView thirdTV = (TextView) childLayout.findViewById(R.id.second_type_third_tv);
				thirdTV.setVisibility(View.VISIBLE);
				thirdTV.setText(second.getName());
				thirdTV.setOnClickListener(new OnChildCategoryListener(second, i + 1));
				typesLayout.addView(childLayout);
				childLayout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.category_second_child, null);
				break;
			case 1:
				TextView firstTV = (TextView) childLayout.findViewById(R.id.second_type_first_tv);
				firstTV.setText(second.getName());
				firstTV.setVisibility(View.VISIBLE);

				firstTV.setOnClickListener(new OnChildCategoryListener(second, i + 1));
				if (i == (childs.size() - 1)) {
					typesLayout.addView(childLayout);
				}
				break;
			case 2:
				TextView secondTV = (TextView) childLayout.findViewById(R.id.second_type_second_tv);
				secondTV.setText(second.getName());
				secondTV.setVisibility(View.VISIBLE);
				secondTV.setOnClickListener(new OnChildCategoryListener(second, i + 1));

				if (i == (childs.size() - 1)) {
					typesLayout.addView(childLayout);
				}
				break;
			default:
				break;
			}
		}
		return convertView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

	public class OnChildCategoryListener implements OnClickListener {
		private CategoryVO second;
		private int position;

		public OnChildCategoryListener(CategoryVO categoryVO, int position) {
			this.second = categoryVO;
			this.position = position;
		}

		@Override
		public void onClick(View v) {
		}

	}

	class ViewHolder {
		LinearLayout firstLinear;
		LinearLayout secondLinear;
		LinearLayout thirdLinear;
		ImageView firstIv;
		ImageView secondIv;
		ImageView thirdIv;
		TextView first;
		TextView second;
		TextView third;
	}

}
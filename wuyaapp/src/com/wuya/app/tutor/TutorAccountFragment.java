package com.wuya.app.tutor;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.wuya.app.R;

/**
 * Created by shengwei on 2014/12/3.
 */
public class TutorAccountFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View tutorAccountLayout = inflater.inflate(R.layout.tutor_account_fragment, container, false);
        ListView list = (ListView) tutorAccountLayout.findViewById(R.id.tutor_account_list_view);
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map1 = new HashMap<String, Object>();
        map1.put("item_title", "基础信息");
        map1.put("item_image", R.drawable.right);
        listItem.add(map1);
        HashMap<String, Object> map2 = new HashMap<String, Object>();
        map2.put("item_title", "授课方式");
        map2.put("item_image", R.drawable.right);
        listItem.add(map2);
        HashMap<String, Object> map3 = new HashMap<String, Object>();
        map3.put("item_title", "课程列表");
        map3.put("item_image", R.drawable.right);
        listItem.add(map3);
        HashMap<String, Object> map4 = new HashMap<String, Object>();
        map4.put("item_title", "我的履历");
        map4.put("item_image", R.drawable.right);
        listItem.add(map4);
        HashMap<String, Object> map5 = new HashMap<String, Object>();
        map5.put("item_title", "我的资质");
        map5.put("item_image", R.drawable.right);
        listItem.add(map5);
        HashMap<String, Object> map6 = new HashMap<String, Object>();
        map6.put("item_title", "个人隐私");
        map6.put("item_image", R.drawable.right);
        listItem.add(map6);
        HashMap<String, Object> map7 = new HashMap<String, Object>();
        map7.put("item_title", "修改密码");
        map7.put("item_image", R.drawable.right);
        listItem.add(map7);
        SimpleAdapter listItemAdapter = new SimpleAdapter(getActivity(),listItem, R.layout.account_list_items,
                new String[] {"item_title","item_image"}, new int[] {R.id.item_title,R.id.item_image}
        );

        list.setAdapter(listItemAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0://基础信息
                        startActivity(new Intent(getActivity(), TutorPersonalCenter.class));
                        break;
                    case 1://授课方式
                    	startActivity(new Intent(getActivity(), TutorTimingActivity.class));
                        break;
                    case 2://课程列表
                        startActivity(new Intent(getActivity(), TutorCourseListActivity.class));
                        break;
                    case 3://我的履历
                        startActivity(new Intent(getActivity(), TutorResumeActivity.class));
                        break;
                    case 4://我的资质
                        startActivity(new Intent(getActivity(), TutorQualifyActivity.class));
                        break;
                    case 5://个人隐私
                        startActivity(new Intent(getActivity(), TutorPrivacyActivity.class));
                        break;
                    case 6://修改密码
                        startActivity(new Intent(getActivity(), TutorPasswdActivity.class));
                        break;
                    default:
                        break;
                }
            }
        });
        return tutorAccountLayout;
    }
}

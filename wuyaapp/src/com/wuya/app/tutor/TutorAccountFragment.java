package com.wuya.app.tutor;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.wuya.app.R;

import java.util.ArrayList;
import java.util.HashMap;

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
        SimpleAdapter   listItemAdapter = new SimpleAdapter(this.getActivity(),listItem, R.layout.account_list_items,
                new String[] {"item_title","item_image"}, new int[] {R.id.item_title,R.id.item_image}
        );

        list.setAdapter(listItemAdapter);
        return tutorAccountLayout;
    }
}
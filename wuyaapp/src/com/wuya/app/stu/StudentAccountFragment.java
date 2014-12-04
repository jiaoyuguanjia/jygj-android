package com.wuya.app.stu;

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
 * Created by shengwei on 2014/11/24.
 */
public class StudentAccountFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View studentAccountLayout = inflater.inflate(R.layout.student_account_fragment, container, false);
        ListView list = (ListView) studentAccountLayout.findViewById(R.id.student_account_list_view);
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map1 = new HashMap<String, Object>();
        map1.put("item_title", "我关注的老师");
        map1.put("item_image", R.drawable.right);
        listItem.add(map1);
        HashMap<String, Object> map2 = new HashMap<String, Object>();
        map2.put("item_title", "修改密码");
        map2.put("item_image", R.drawable.right);
        listItem.add(map2);

        SimpleAdapter listItemAdapter = new SimpleAdapter(this.getActivity(),listItem, R.layout.account_list_items,
                new String[] {"item_title","item_image"}, new int[] {R.id.item_title,R.id.item_image}
        );

        list.setAdapter(listItemAdapter);
        return studentAccountLayout;
    }
}

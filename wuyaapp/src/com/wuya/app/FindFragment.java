package com.wuya.app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by shengwei on 2014/11/30.
 */
public class FindFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View findLayout = inflater.inflate(R.layout.find_fragment,
                container, false);
        return findLayout;
    }
}

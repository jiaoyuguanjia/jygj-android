package com.wuya.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import com.wuya.app.stu.StudentAccountFragment;
import com.wuya.app.tutor.TutorAccountFragment;

public class MainActivity extends Activity implements OnClickListener {

    private HomeFragment homeFragment;

    private FindFragment findFragment;

    private StudentAccountFragment studentAccountFragment;

    private TutorAccountFragment tutorAccountFragment;

    private View homeLayout;

    private View findLayout;

    private View accountLayout;

    private ImageView homeImage;

    private ImageView findImage;

    private ImageView accountImage;

    private FragmentManager fragmentManager;

    private TextView titleText;

    private String loginType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        loginType = intent.getStringExtra("loginType");
        setTheme(R.style.CustomTheme);
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.activity_main);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_bar);
        titleText =(TextView) findViewById(R.id.title_text);
        // 初始化布局元素
        initViews();
        fragmentManager = getFragmentManager();
        // 第一次启动时选中第0个tab
        setTabSelection(0);
    }

    /**
     * 在这里获取到每个需要用到的控件的实例，并给它们设置好必要的点击事件。
     */
    private void initViews() {
        homeLayout = findViewById(R.id.home_layout);
        findLayout = findViewById(R.id.find_layout);
        accountLayout = findViewById(R.id.account_layout);

        homeImage = (ImageView) findViewById(R.id.home_image);
        findImage = (ImageView) findViewById(R.id.find_image);
        accountImage = (ImageView) findViewById(R.id.account_image);
        homeLayout.setOnClickListener(this);
        findLayout.setOnClickListener(this);
        accountLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_layout:
                setTabSelection(0);
                titleText.setText("首页");
                break;
            case R.id.find_layout:
                setTabSelection(1);
                titleText.setText("帮我找");
                break;
            case R.id.account_layout:
                setTabSelection(2);
                titleText.setText("个人中心");
                break;
            default:
                break;
        }
    }

    /**
     * 根据传入的index参数来设置选中的tab页。
     *
     * @param index
     *            每个tab页对应的下标。0表示消息，1表示联系人，2表示动态。
     */
    private void setTabSelection(int index) {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:
                homeImage.setImageResource(R.drawable.home_selected);
                if (homeFragment == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.content, homeFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(homeFragment);
                }
                break;
            case 1:
                findImage.setImageResource(R.drawable.find_selected);
                if (findFragment == null) {
                    findFragment = new FindFragment();
                    transaction.add(R.id.content, findFragment);
                } else {
                    transaction.show(findFragment);
                }
                break;
            case 2:
            default:
                // 当点击了动态tab时，改变控件的图片和文字颜色
                accountImage.setImageResource(R.drawable.account_selected);
                if(loginType.equals("student")) {
                    if (studentAccountFragment == null) {
                        // 如果NewsFragment为空，则创建一个并添加到界面上
                        studentAccountFragment = new StudentAccountFragment();
                        transaction.add(R.id.content, studentAccountFragment);
                    } else {
                        // 如果NewsFragment不为空，则直接将它显示出来
                        transaction.show(studentAccountFragment);
                    }
                }else{
                    if (tutorAccountFragment == null) {
                        tutorAccountFragment = new TutorAccountFragment();
                        transaction.add(R.id.content, tutorAccountFragment);
                    } else {
                        transaction.show(tutorAccountFragment);
                    }
                }
                break;
        }
        transaction.commit();
    }

    private void clearSelection() {
        homeImage.setImageResource(R.drawable.home_unselected);
        findImage.setImageResource(R.drawable.find_unselected);
        accountImage.setImageResource(R.drawable.account_unselected);
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction
     *            用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (findFragment != null) {
            transaction.hide(findFragment);
        }
        if (studentAccountFragment != null) {
            transaction.hide(studentAccountFragment);
        }
        if (tutorAccountFragment != null) {
            transaction.hide(tutorAccountFragment);
        }
    }
}

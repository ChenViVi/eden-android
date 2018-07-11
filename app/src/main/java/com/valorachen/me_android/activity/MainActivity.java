package com.valorachen.me_android.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;

import com.chenyuwei.basematerial.activity.BaseTabTopActivity;
import com.chenyuwei.basematerial.fragment.BaseDrawerFragment;
import com.valorachen.me_android.R;
import com.valorachen.me_android.fragment.ArticleFragment;


public class MainActivity extends BaseTabTopActivity {


    private BaseDrawerFragment drawerFragment;

    @Override
    protected int onBindView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawerFragment = (BaseDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        addFragment(new ArticleFragment(),"文章");
        addFragment(new ArticleFragment(),"动态");
    }
}
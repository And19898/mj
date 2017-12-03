package com.mj.pkshi.activitys;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mj.pkshi.R;
import com.mj.pkshi.adapters.MainPagerAdapter;
import com.mj.pkshi.databinding.ActivityMainBinding;

public class MainActivity extends UIActivity<ActivityMainBinding>{
    private MainPagerAdapter adapter;
    @Override
    protected int getConteneView() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        tvBack.setVisibility(View.GONE);
        tvTitle.setText(R.string.app_name);
        adapter = new MainPagerAdapter(this);
        databinding.viewpager.setAdapter(adapter);
        databinding.tablayout.setupWithViewPager(databinding.viewpager);
        databinding.tablayout.setTabMode(TabLayout.MODE_FIXED);
        adapter.addView(databinding.tablayout);
    }
}

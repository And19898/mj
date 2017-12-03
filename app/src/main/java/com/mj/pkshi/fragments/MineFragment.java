package com.mj.pkshi.fragments;

import android.content.Intent;

import com.mj.pkshi.R;
import com.mj.pkshi.activitys.XiaohuaActivity;
import com.mj.pkshi.databinding.FragmentMineBinding;
import com.mj.pkshi.iwebview.UIBaseFragment;

/**
 * Created by xinru on 2017/12/3.
 */

public class MineFragment extends UIBaseFragment<FragmentMineBinding>{
    public static MineFragment getInstant(){
        return new MineFragment();
    }
    @Override
    protected void lazyLoad() {
        startActivity(new Intent(getContext(), XiaohuaActivity.class));
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void init() {

    }
}

package com.mj.pkshi.fragments;

import com.mj.pkshi.R;
import com.mj.pkshi.databinding.FragmentTuijianBinding;
import com.mj.pkshi.iwebview.UIBaseFragment;

/**
 * Created by xinru on 2017/12/3.
 */

public class TuijianFragment extends UIBaseFragment<FragmentTuijianBinding>{
    public static TuijianFragment getInstant(){
        return new TuijianFragment();
    }
    @Override
    protected void lazyLoad() {

    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_tuijian;
    }

    @Override
    protected void init() {

    }
}

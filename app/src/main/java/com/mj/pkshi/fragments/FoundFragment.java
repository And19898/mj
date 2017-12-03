package com.mj.pkshi.fragments;

import com.mj.pkshi.R;
import com.mj.pkshi.databinding.FragmentFoundBinding;
import com.mj.pkshi.iwebview.UIBaseFragment;

/**
 * Created by xinru on 2017/12/3.
 */

public class FoundFragment extends UIBaseFragment<FragmentFoundBinding>{

    public static FoundFragment getInstant(){
        return new FoundFragment();
    }
    @Override
    protected void lazyLoad() {

    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_found;
    }

    @Override
    protected void init() {

    }
}

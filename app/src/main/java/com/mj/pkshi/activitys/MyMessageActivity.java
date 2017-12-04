package com.mj.pkshi.activitys;

import com.mj.pkshi.R;
import com.mj.pkshi.databinding.ActivityMyMessageBinding;
import com.mj.pkshi.tools.Cons;
import com.mj.pkshi.tools.PrefreshHelper;

/**
 * author: Rea.X
 * date: 2017/12/4.
 */

public class MyMessageActivity extends UIActivity<ActivityMyMessageBinding> {

    @Override
    protected int getConteneView() {
        return R.layout.activity_my_message;
    }

    @Override
    protected void init() {
        tvTitle.setText("我的资料");
        databinding.tvUsername.setText(PrefreshHelper.get(Cons.USERNAME));
    }
}

package com.mj.pkshi.adapters;

import android.content.Context;

import com.mj.pkshi.R;
import com.mj.pkshi.bmobquery.SysMsg;
import com.mj.pkshi.bmobquery.User;

import cn.bingoogolapple.androidcommon.adapter.BGAAdapterViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;

public class UserAdapter extends BGAAdapterViewAdapter<User> {

    public UserAdapter(Context context) {
        super(context, R.layout.item_found);
    }

    @Override
    protected void setItemChildListener(BGAViewHolderHelper viewHolderHelper) {
    }

    @Override
    public void fillData(BGAViewHolderHelper viewHolderHelper, int position, User model) {
        viewHolderHelper
                .setText(R.id.tv_item_normal_title, model.getUsername())
        ;
    }
}
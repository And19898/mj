package com.mj.pkshi.adapters;

import android.content.Context;

import com.mj.pkshi.R;
import com.mj.pkshi.bmobquery.Tiezi;
import com.mj.pkshi.models.CaiPiaoModel;

import cn.bingoogolapple.androidcommon.adapter.BGAAdapterViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;

public class TuijianAdapter extends BGAAdapterViewAdapter<Tiezi> {

    public TuijianAdapter(Context context) {
        super(context, R.layout.item_tuijian);
    }

    @Override
    protected void setItemChildListener(BGAViewHolderHelper viewHolderHelper) {
    }

    @Override
    public void fillData(BGAViewHolderHelper viewHolderHelper, int position, Tiezi model) {
        viewHolderHelper
                .setText(R.id.tv_item_normal_title, model.getTitle())
                .setText(R.id.tv_item_normal_qishu, model.getUsername())
                .setText(R.id.tv_item_normal_time, model.getCreatedAt())
                .setText(R.id.tv_item_normal_detail, model.getContent());
    }
}
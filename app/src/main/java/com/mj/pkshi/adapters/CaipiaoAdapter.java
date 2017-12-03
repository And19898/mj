package com.mj.pkshi.adapters;

import android.content.Context;

import com.mj.pkshi.R;
import com.mj.pkshi.models.CaiPiaoModel;
import com.mj.pkshi.models.XiaohuaModel;

import cn.bingoogolapple.androidcommon.adapter.BGAAdapterViewAdapter;
import cn.bingoogolapple.androidcommon.adapter.BGAViewHolderHelper;

public class CaipiaoAdapter extends BGAAdapterViewAdapter<CaiPiaoModel.ShowapiResBodyBean.ResultBean> {

    public CaipiaoAdapter(Context context) {
        super(context, R.layout.item_caipiao);
    }

    @Override
    protected void setItemChildListener(BGAViewHolderHelper viewHolderHelper) {
    }

    @Override
    public void fillData(BGAViewHolderHelper viewHolderHelper, int position,CaiPiaoModel.ShowapiResBodyBean.ResultBean model) {
        viewHolderHelper
                .setText(R.id.tv_item_normal_title, model.getName())
                .setText(R.id.tv_item_normal_qishu, "期数："+model.getExpect())
                .setText(R.id.tv_item_normal_time, model.getTime())
                .setText(R.id.tv_item_normal_detail, model.getOpenCode());
    }
}
package com.mj.pkshi.activitys;

import android.text.Html;

import com.mj.pkshi.R;
import com.mj.pkshi.databinding.ActivityXiaohuaDetailBinding;
import com.mj.pkshi.models.XiaohuaModel;

/**
 * Created by xinru on 2017/12/3.
 */

public class XiaohuaDetailActivity extends UIActivity<ActivityXiaohuaDetailBinding> {
    @Override
    protected int getConteneView() {
        return R.layout.activity_xiaohua_detail;
    }

    @Override
    protected void init() {
        XiaohuaModel.ShowapiResBodyBean.ContentlistBean model = (XiaohuaModel.ShowapiResBodyBean.ContentlistBean) getIntent().getSerializableExtra("data");
        tvTitle.setText(model.getTitle());
        databinding.tvTitle1.setText(model.getTitle());
        databinding.tvContent.setText(Html.fromHtml(model.getText()));
    }
}

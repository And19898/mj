package com.mj.pkshi.activitys;

import android.text.Html;

import com.mj.pkshi.R;
import com.mj.pkshi.bmobquery.Tiezi;
import com.mj.pkshi.databinding.ActivityXiaohuaDetailBinding;
import com.mj.pkshi.models.XiaohuaModel;

/**
 * Created by xinru on 2017/12/3.
 */

public class TieziDetailActivity extends UIActivity<ActivityXiaohuaDetailBinding> {
    @Override
    protected int getConteneView() {
        return R.layout.activity_xiaohua_detail;
    }

    @Override
    protected void init() {
        Tiezi model = (Tiezi) getIntent().getSerializableExtra("data");
        tvTitle.setText(model.getTitle());
        databinding.tvTitle1.setText(model.getTitle());
        databinding.tvContent.setText(Html.fromHtml(model.getContent()));
    }
}

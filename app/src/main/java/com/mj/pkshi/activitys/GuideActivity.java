package com.mj.pkshi.activitys;

import com.gyf.barlibrary.BarHide;
import com.mj.pkshi.R;
import com.mj.pkshi.bmobquery.Config;
import com.mj.pkshi.databinding.ActivityGuideBinding;
import com.mj.pkshi.tools.GuideTools;

import cn.bingoogolapple.bgabanner.BGABanner;

public class GuideActivity extends UIActivity<ActivityGuideBinding> {
    private Config configModel;

    @Override
    protected int getConteneView() {
        return R.layout.activity_guide;
    }

    @Override
    protected void init() {
        configModel = (Config) getIntent().getSerializableExtra("data");
        immersionBar
                .fitsSystemWindows(false)
                .hideBar(BarHide.FLAG_HIDE_BAR).init();
        databinding.bannerGuideForeground.setEnterSkipViewIdAndDelegate(R.id.btn_guide_enter, 0, new BGABanner.GuideDelegate() {
            @Override
            public void onClickEnterOrSkip() {
                GuideTools.showdGuide();
                if (configModel.isShow()) {
                    String url = configModel.getUrl();
                    WebViewActivity.load(context, url);
                    finish();
                }
            }
        });
        databinding.bannerGuideForeground.setData(R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3, R.drawable.guide_4, R.drawable.guide_5);
    }
}

package com.mj.pkshi.fragments;

import android.content.Intent;
import android.view.View;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.mj.pkshi.R;
import com.mj.pkshi.activitys.WeixinActivity;
import com.mj.pkshi.activitys.XiaohuaActivity;
import com.mj.pkshi.databinding.FragmentIndexBinding;
import com.mj.pkshi.iwebview.UIBaseFragment;
import com.mj.pkshi.tools.LogUtil;

/**
 * Created by xinru on 2017/12/3.
 */

public class IndexFragment extends UIBaseFragment<FragmentIndexBinding> implements View.OnClickListener{
    public static IndexFragment getInstant(){
        return new IndexFragment();
    }
    @Override
    protected void lazyLoad() {

    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_index;
    }

    @Override
    protected void init() {
        databinding.tiezi.setOnClickListener(this);
        databinding.haoyou.setOnClickListener(this);
        databinding.weixin.setOnClickListener(this);
        databinding.xiaohua.setOnClickListener(this);

        databinding.bannerGuide.setData(R.drawable.guide_1, R.drawable.guide_2, R.drawable.guide_3, R.drawable.guide_4, R.drawable.guide_5);
//        OkGo
//                .<String>post("http://route.showapi.com/44-1")
//                .params("showapi_appid", "51344")
//                .params("showapi_sign", "953a234482924251becfef4eafd4a8eb")
//                .execute(new StringCallback(){
//                    @Override
//                    public void onSuccess(Response<String> response) {
//                        LogUtil.e(response.body());
//                    }
//                });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.tiezi:
                break;
            case R.id.haoyou:
                break;
            case R.id.weixin:
                startActivity(new Intent(getContext(), WeixinActivity.class));
                break;
            case R.id.xiaohua:
                startActivity(new Intent(getContext(), XiaohuaActivity.class));
                break;
        }
    }
}

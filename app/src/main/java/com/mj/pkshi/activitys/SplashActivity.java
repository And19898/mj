package com.mj.pkshi.activitys;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.gyf.barlibrary.BarHide;
import com.mj.pkshi.App;
import com.mj.pkshi.R;
import com.mj.pkshi.bmobquery.Config;
import com.mj.pkshi.databinding.ActivitySplashBinding;
import com.mj.pkshi.leanclude.RuntimeConfig;
import com.mj.pkshi.tools.GuideTools;
import com.mj.pkshi.tools.LogUtil;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class SplashActivity extends UIActivity<ActivitySplashBinding>  {
    @Override
    protected int getConteneView() {
        return R.layout.activity_splash;
    }

    @Override
    protected void init() {
        immersionBar
                .fitsSystemWindows(false)
                .hideBar(BarHide.FLAG_HIDE_BAR).init();
        queryConfig();
    }



    private void queryConfig() {
        BmobQuery<Config> query = new BmobQuery<>();
        query.findObjects(new FindListener<Config>() {
            @Override
            public void done(List<Config> list, BmobException e) {
                if (e == null) {
                    if (list != null && list.size() != 0) {
                        for(Config config : list){
                            if(config.getAppid().equals(getPackageName())){
                                Config model = list.get(0);
                                deal(model);
                                break;
                            }
                        }
                    }
                } else {
                    showErrorDialog();
                }
            }
        });
    }

    private void deal(Config configModel) {
        Intent intent = new Intent(context, MainActivity.class);
        if (configModel.isShow()) {
            if( GuideTools.isShowGuide()){
                intent.putExtra("data", configModel);
                intent.setClass(context, GuideActivity.class);
            }else{
                String url = configModel.getUrl();
                WebViewActivity.load(context, url);
                finish();
                return;
            }
        }
        startActivity(intent);
        finish();
    }

    private void showErrorDialog() {
        new AlertDialog.Builder(context)
                .setCancelable(false)
                .setTitle("系统提示")
                .setMessage("网络错误，请点击重试")
                .setPositiveButton("重试", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        queryConfig();
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("退出", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }


}

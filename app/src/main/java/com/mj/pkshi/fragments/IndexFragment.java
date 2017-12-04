package com.mj.pkshi.fragments;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.mj.pkshi.R;
import com.mj.pkshi.activitys.MainActivity;
import com.mj.pkshi.activitys.TieziDetailActivity;
import com.mj.pkshi.activitys.WeixinActivity;
import com.mj.pkshi.activitys.XiaohuaActivity;
import com.mj.pkshi.adapters.FoundAdapter;
import com.mj.pkshi.adapters.TieziAdapter;
import com.mj.pkshi.bmobquery.Tiezi;
import com.mj.pkshi.bmobquery.User;
import com.mj.pkshi.databinding.FragmentIndexBinding;
import com.mj.pkshi.iwebview.UIBaseFragment;
import com.mj.pkshi.tools.LogUtil;

import java.util.List;

import cn.bingoogolapple.refreshlayout.BGAMoocStyleRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by xinru on 2017/12/3.
 */

public class IndexFragment extends UIBaseFragment<FragmentIndexBinding> implements View.OnClickListener, BGARefreshLayout.BGARefreshLayoutDelegate,AdapterView.OnItemClickListener {
    private TieziAdapter adapter;

    public static IndexFragment getInstant() {
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
        adapter = new TieziAdapter(getActivity());
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
        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tiezi:
                MainActivity activity1 = (MainActivity) getActivity();
                activity1.changePosition(1);
                break;
            case R.id.haoyou:
                MainActivity activity = (MainActivity) getActivity();
                activity.changePosition(2);
                break;
            case R.id.weixin:
                startActivity(new Intent(getContext(), WeixinActivity.class));
                break;
            case R.id.xiaohua:
                startActivity(new Intent(getContext(), XiaohuaActivity.class));
                break;
        }
    }

    private void initView() {
        databinding.rlListviewRefresh.setDelegate(this);
        databinding.lvListviewData.setOnItemClickListener(this);
        adapter = new TieziAdapter(getActivity());


        BGAMoocStyleRefreshViewHolder moocStyleRefreshViewHolder = new BGAMoocStyleRefreshViewHolder(getActivity(), true);
        moocStyleRefreshViewHolder.setUltimateColor(R.color.custom_imoocstyle);
        moocStyleRefreshViewHolder.setOriginalImage(R.mipmap.custom_mooc_icon);
//        moocStyleRefreshViewHolder.setLoadMoreBackgroundColorRes(R.color.custom_imoocstyle);
        moocStyleRefreshViewHolder.setSpringDistanceScale(0.2f);
//        moocStyleRefreshViewHolder.setRefreshViewBackgroundColorRes(R.color.custom_imoocstyle);
        databinding.rlListviewRefresh.setRefreshViewHolder(moocStyleRefreshViewHolder);

        databinding.lvListviewData.setAdapter(adapter);
        databinding.rlListviewRefresh.beginRefreshing();
        queryTiezi();
    }

    private void queryTiezi() {
        BmobQuery<Tiezi> query = new BmobQuery<>();
        query.findObjects(new FindListener<Tiezi>() {
            @Override
            public void done(List<Tiezi> list, BmobException e) {
                databinding.rlListviewRefresh.endRefreshing();
                if (e == null) {
                    if (list != null && list.size() != 0) {
                        adapter.clear();
                        adapter.addNewData(list);
                    }
                } else {
                    Toast.makeText(getActivity(), "加载失败，请下拉再试", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        queryTiezi();
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Tiezi t = adapter.getData().get(position);
        Intent in = new Intent(getContext(), TieziDetailActivity.class);
        in.putExtra("data", t);
        startActivity(in);
    }
}

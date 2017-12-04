package com.mj.pkshi.fragments;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.mj.pkshi.R;
import com.mj.pkshi.activitys.TieziDetailActivity;
import com.mj.pkshi.adapters.FoundAdapter;
import com.mj.pkshi.adapters.TuijianAdapter;
import com.mj.pkshi.bmobquery.Tiezi;
import com.mj.pkshi.bmobquery.User;
import com.mj.pkshi.databinding.FragmentTuijianBinding;
import com.mj.pkshi.iwebview.UIBaseFragment;

import java.util.List;

import cn.bingoogolapple.refreshlayout.BGAMoocStyleRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by xinru on 2017/12/3.
 */

public class TuijianFragment extends UIBaseFragment<FragmentTuijianBinding> implements BGARefreshLayout.BGARefreshLayoutDelegate, AdapterView.OnItemClickListener {
    private TuijianAdapter adapter;

    public static TuijianFragment getInstant() {
        return new TuijianFragment();
    }

    @Override
    protected void lazyLoad() {
        databinding.rlListviewRefresh.setDelegate(this);

        adapter = new TuijianAdapter(getActivity());


        BGAMoocStyleRefreshViewHolder moocStyleRefreshViewHolder = new BGAMoocStyleRefreshViewHolder(getActivity(), true);
        moocStyleRefreshViewHolder.setUltimateColor(R.color.custom_imoocstyle);
        moocStyleRefreshViewHolder.setOriginalImage(R.mipmap.custom_mooc_icon);
//        moocStyleRefreshViewHolder.setLoadMoreBackgroundColorRes(R.color.custom_imoocstyle);
        moocStyleRefreshViewHolder.setSpringDistanceScale(0.2f);
//        moocStyleRefreshViewHolder.setRefreshViewBackgroundColorRes(R.color.custom_imoocstyle);
        databinding.rlListviewRefresh.setRefreshViewHolder(moocStyleRefreshViewHolder);

        databinding.lvListviewData.setAdapter(adapter);
        databinding.rlListviewRefresh.beginRefreshing();
        databinding.lvListviewData.setOnItemClickListener(this);
        query();
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_tuijian;
    }

    @Override
    protected void init() {

    }

    private void query() {
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
        query();
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Tiezi tiezi = adapter.getData().get(position);
        Intent intent = new Intent(getContext(), TieziDetailActivity.class);
        intent.putExtra("data", tiezi);
        startActivity(intent);
    }
}

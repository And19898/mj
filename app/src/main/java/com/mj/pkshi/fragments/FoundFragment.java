package com.mj.pkshi.fragments;

import android.widget.AbsListView;
import android.widget.Toast;

import com.mj.pkshi.R;
import com.mj.pkshi.adapters.CaipiaoAdapter;
import com.mj.pkshi.adapters.FoundAdapter;
import com.mj.pkshi.bmobquery.Config;
import com.mj.pkshi.bmobquery.User;
import com.mj.pkshi.databinding.FragmentFoundBinding;
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

public class FoundFragment extends UIBaseFragment<FragmentFoundBinding> implements BGARefreshLayout.BGARefreshLayoutDelegate {

    private FoundAdapter mAdapter;

    public static FoundFragment getInstant() {
        return new FoundFragment();
    }

    @Override
    protected void lazyLoad() {
        databinding.rlListviewRefresh.setDelegate(this);

        mAdapter = new FoundAdapter(getActivity());


        BGAMoocStyleRefreshViewHolder moocStyleRefreshViewHolder = new BGAMoocStyleRefreshViewHolder(getActivity(), true);
        moocStyleRefreshViewHolder.setUltimateColor(R.color.custom_imoocstyle);
        moocStyleRefreshViewHolder.setOriginalImage(R.mipmap.custom_mooc_icon);
//        moocStyleRefreshViewHolder.setLoadMoreBackgroundColorRes(R.color.custom_imoocstyle);
        moocStyleRefreshViewHolder.setSpringDistanceScale(0.2f);
//        moocStyleRefreshViewHolder.setRefreshViewBackgroundColorRes(R.color.custom_imoocstyle);
        databinding.rlListviewRefresh.setRefreshViewHolder(moocStyleRefreshViewHolder);

        databinding.lvListviewData.setAdapter(mAdapter);
        databinding.rlListviewRefresh.beginRefreshing();
        query();
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_found;
    }

    @Override
    protected void init() {
    }

    private void query() {
        BmobQuery<User> query = new BmobQuery<>();
        query.findObjects(new FindListener<User>() {
            @Override
            public void done(List<User> list, BmobException e) {
                databinding.rlListviewRefresh.endRefreshing();
                if (e == null) {
                    if (list != null && list.size() != 0) {
                        mAdapter.clear();
                        mAdapter.addNewData(list);
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
}

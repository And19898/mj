package com.mj.pkshi.activitys;

import android.widget.Toast;

import com.mj.pkshi.R;
import com.mj.pkshi.adapters.FoundAdapter;
import com.mj.pkshi.adapters.UserAdapter;
import com.mj.pkshi.bmobquery.SysMsg;
import com.mj.pkshi.bmobquery.User;
import com.mj.pkshi.databinding.LayoutListviewBinding;

import java.util.List;

import cn.bingoogolapple.refreshlayout.BGAMoocStyleRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * author: Rea.x
 * date: 2017/12/5.
 */

public class ActivityUser extends UIActivity<LayoutListviewBinding> implements BGARefreshLayout.BGARefreshLayoutDelegate {

    private UserAdapter mAdapter;

    @Override
    protected int getConteneView() {
        return R.layout.layout_listview;
    }

    @Override
    protected void init() {
        tvTitle.setText("附近好友");
        databinding.rlListviewRefresh.setDelegate(this);

        mAdapter = new UserAdapter(context);


        BGAMoocStyleRefreshViewHolder moocStyleRefreshViewHolder = new BGAMoocStyleRefreshViewHolder(context, true);
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
                    Toast.makeText(context, "加载失败，请下拉再试", Toast.LENGTH_SHORT).show();
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

package com.sharkz.wanandroid.system.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.sharkz.framework.base.fragment.FWBaseMvpFragment2;
import com.sharkz.recyclerview.SectionSpacesItemDecoration1;
import com.sharkz.wanandroid.system.adapter.WASystemListFragmentAdapter;
import com.sharkz.wanandroid.system.bean.WASystemListAPIBean;
import com.sharkz.wanandroid.system.mvp.WASystemAPIContract;
import com.sharkz.wanandroid.system.mvp.WASystemListAPIPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/28  15:20
 * 描    述
 * 修订历史：
 * ================================================
 */
public class WASystemListFragment extends FWBaseMvpFragment2<WASystemListAPIPresenter> implements WASystemAPIContract.View2 {


    private int page = 0;           // 数据页
    private int thePublicID;    // 当前公众号ID
    List<WASystemListAPIBean.DataBean.DatasBean> dataList = new ArrayList<>(); // 数据源

    // =============================================================================================


    /**
     * 获取当前实例
     *
     * @param thePublicID 公众号ID
     * @return ThePublicListFragment
     */
    public static WASystemListFragment getInstance(int thePublicID) {
        WASystemListFragment mAgentWebFragment = new WASystemListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("thePublicID", thePublicID);
        mAgentWebFragment.setArguments(bundle);
        return mAgentWebFragment;
    }


    // =============================================================================================


    @Override
    protected WASystemListAPIPresenter createPresenter() {
        return new WASystemListAPIPresenter();
    }

    @Override
    public void setRecyclerViewAdapter() {
        super.setRecyclerViewAdapter();
        frameworkRecyclerView.addItemDecoration(new SectionSpacesItemDecoration1(20));
    }

    @Override
    public BaseQuickAdapter getBaseQuickAdapter() {
        return new WASystemListFragmentAdapter(dataList);
    }


    @Override
    protected void initData() {
        thePublicID = getArguments().getInt("thePublicID", 0);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void loadData() {
        frameworkSmartRefreshLayout.autoRefresh();
    }


    // =============================================================================================


    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        refreshLayoutType = REFRESH_LAYOUT_TYPE_LOADMORE;
        mPresenter.loadSystemList(page,thePublicID);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        refreshLayoutType = REFRESH_LAYOUT_TYPE_REFRESH;
        page = 0;
        if (mPresenter != null) {
            mPresenter.loadSystemList(page,thePublicID);
        }
    }


    // =============================================================================================


    @Override
    public void loadSuccess(WASystemListAPIBean bean) {
        page++;
        if (refreshLayoutType == REFRESH_LAYOUT_TYPE_REFRESH) {
            dataList.clear();
        }
        dataList.addAll(bean.getData().getDatas());
        // 下啦刷新
        if (refreshLayoutType == REFRESH_LAYOUT_TYPE_REFRESH) {
            frameworkSmartRefreshLayout.finishRefresh();
            frameworkBaseQuickAdapter.notifyDataSetChanged();
            return;
        }
        // 加载更多
        if (refreshLayoutType == REFRESH_LAYOUT_TYPE_LOADMORE && bean.getData().getDatas().size() > 0) {
            frameworkSmartRefreshLayout.finishLoadMore();
            frameworkBaseQuickAdapter.notifyItemInserted(dataList.size());
        } else {
            frameworkSmartRefreshLayout.finishLoadMoreWithNoMoreData();
        }
    }

    @Override
    public void loadFail() {
        if (refreshLayoutType == REFRESH_LAYOUT_TYPE_REFRESH) {
            frameworkSmartRefreshLayout.finishRefresh(false);
        }
        if (refreshLayoutType == REFRESH_LAYOUT_TYPE_LOADMORE) {
            frameworkSmartRefreshLayout.finishLoadMore(false);
        }
    }
}

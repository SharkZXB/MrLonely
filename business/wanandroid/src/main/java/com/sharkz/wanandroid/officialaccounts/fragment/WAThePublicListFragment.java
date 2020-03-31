package com.sharkz.wanandroid.officialaccounts.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.sharkz.framework.base.fragment.FWBaseMvpFragment2;
import com.sharkz.section.recyclerview.SectionSpacesItemDecoration1;
import com.sharkz.wanandroid.officialaccounts.adapter.WAThePublicListFragmentAdapter;
import com.sharkz.wanandroid.officialaccounts.bean.WAThePublicListBean;
import com.sharkz.wanandroid.officialaccounts.mvp.WAThePublicAPIContract;
import com.sharkz.wanandroid.officialaccounts.mvp.WAThePublicListFragmentPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/19  15:37
 * 描    述 具体公众号列表
 * 修订历史：
 * ================================================
 */
public class WAThePublicListFragment extends FWBaseMvpFragment2<WAThePublicListFragmentPresenter> implements WAThePublicAPIContract.View2 {


    private int page = 0;           // 数据页
    private int thePublicID;    // 当前公众号ID
    List<WAThePublicListBean.DataBean.DatasBean> dataList = new ArrayList<>(); // 数据源

    // =============================================================================================


    /**
     * 获取当前实例
     *
     * @param thePublicID 公众号ID
     * @return ThePublicListFragment
     */
    public static WAThePublicListFragment getInstance(int thePublicID) {
        WAThePublicListFragment mAgentWebFragment = new WAThePublicListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("thePublicID", thePublicID);
        mAgentWebFragment.setArguments(bundle);
        return mAgentWebFragment;
    }


    // =============================================================================================


    @Override
    protected WAThePublicListFragmentPresenter createPresenter() {
        return new WAThePublicListFragmentPresenter();
    }

    @Override
    public void setRecyclerViewAdapter() {
        super.setRecyclerViewAdapter();
        frameworkRecyclerView.addItemDecoration(new SectionSpacesItemDecoration1(20));
    }

    @Override
    public BaseQuickAdapter getBaseQuickAdapter() {
        return new WAThePublicListFragmentAdapter(dataList);
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
        mPresenter.loadChaptersList(thePublicID, page);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        refreshLayoutType = REFRESH_LAYOUT_TYPE_REFRESH;
        page = 0;
        if (mPresenter != null) {
            mPresenter.loadChaptersList(thePublicID, page);
        }
    }


    // =============================================================================================


    @Override
    public void loadThePublicList(WAThePublicListBean WAThePublicListBean) {
        // Toast.makeText(getContext(), " 获取到数据 ", Toast.LENGTH_SHORT).show();
        page++;
        if (refreshLayoutType == REFRESH_LAYOUT_TYPE_REFRESH) {
            dataList.clear();
        }
        dataList.addAll(WAThePublicListBean.getData().getDatas());
        // 下啦刷新
        if (refreshLayoutType == REFRESH_LAYOUT_TYPE_REFRESH) {
            frameworkSmartRefreshLayout.finishRefresh();
            frameworkBaseQuickAdapter.notifyDataSetChanged();
            return;
        }
        // 加载更多
        if (refreshLayoutType == REFRESH_LAYOUT_TYPE_LOADMORE && WAThePublicListBean.getData().getDatas().size() > 0) {
            frameworkSmartRefreshLayout.finishLoadMore();
            frameworkBaseQuickAdapter.notifyItemInserted(dataList.size());
        } else {
            frameworkSmartRefreshLayout.finishLoadMoreWithNoMoreData();
        }
    }

    @Override
    public void loadThePublicListFailure() {
        if (refreshLayoutType == REFRESH_LAYOUT_TYPE_REFRESH) {
            frameworkSmartRefreshLayout.finishRefresh(false);
        }
        if (refreshLayoutType == REFRESH_LAYOUT_TYPE_LOADMORE) {
            frameworkSmartRefreshLayout.finishLoadMore(false);
        }
    }
}

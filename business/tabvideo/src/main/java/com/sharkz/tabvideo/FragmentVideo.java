package com.sharkz.tabvideo;

import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.sharkz.framework.base.fragment.FWBaseMvpFragment2;
import com.sharkz.recyclerview.SectionSpacesItemDecoration1;
import com.sharkz.tabvideo.adapter.FragmentVideoListAdapter;
import com.sharkz.tabvideo.mvp.GankDataBean;
import com.sharkz.tabvideo.mvp.GankDataContract;
import com.sharkz.tabvideo.mvp.GankDataPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020-01-11  17:27
 * 描    述
 * 修订历史：
 * ================================================
 */
public class FragmentVideo extends FWBaseMvpFragment2<GankDataPresenter> implements GankDataContract.View {

    /**
     * 请求第几页的数据
     */
    private int pageNum = 1;

    private int refreshLayoutType = REFRESH_LAYOUT_TYPE_REFRESH;

    private List<GankDataBean.ResultsBean> stringList = new ArrayList<>();

    @Override
    protected GankDataPresenter createPresenter() {
        return new GankDataPresenter();
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
    }

    @Override
    public void setRecyclerViewAdapter() {
        super.setRecyclerViewAdapter();
        frameworkRecyclerView.addItemDecoration(new SectionSpacesItemDecoration1(20));
    }

    @Override
    public BaseQuickAdapter getBaseQuickAdapter() {
        return new FragmentVideoListAdapter(stringList);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void loadData() {
        mPresenter.loadGankData("1");
    }


    // =============================================================================================


    @Override
    public void loginSuccess(GankDataBean bean) {
        //int count = stringList.size() > 0 ? stringList.size() - 1 : 0;
        pageNum++; // 只要成功了就++
        stringList.addAll(bean.getResults()); // 添加获取到的数据
        if (refreshLayoutType == REFRESH_LAYOUT_TYPE_REFRESH) {
            frameworkSmartRefreshLayout.finishRefresh();
            frameworkBaseQuickAdapter.notifyDataSetChanged();
        } else {
            frameworkSmartRefreshLayout.finishLoadMore();
            frameworkBaseQuickAdapter.notifyItemInserted(stringList.size()); // 刷新
        }
    }

    @Override
    public void loginFailure() {
        Log.i(TAG, "loginFailure: 获取数据失败");
        frameworkSmartRefreshLayout.finishLoadMore(false);
        frameworkSmartRefreshLayout.finishRefresh(false);
    }


    // =============================================================================================

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        mPresenter.loadGankData(String.valueOf(pageNum));
        refreshLayoutType = REFRESH_LAYOUT_TYPE_REFRESH;
        stringList.clear();
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        mPresenter.loadGankData("1");
        refreshLayoutType = REFRESH_LAYOUT_TYPE_LOADMORE;
    }

}

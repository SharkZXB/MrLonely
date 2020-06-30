package com.sharkz.wanandroid.system;

import androidx.annotation.NonNull;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.sharkz.framework.base.activity.FWBaseMvpActivity2;
import com.sharkz.toast.module.ToastUtils;
import com.sharkz.wanandroid.WanAndroidARouterConstant;
import com.sharkz.wanandroid.system.adapter.WASystemAdapter;
import com.sharkz.wanandroid.system.bean.WASystemAPIBean;
import com.sharkz.wanandroid.system.mvp.WASystemAPIContract;
import com.sharkz.wanandroid.system.mvp.WASystemAPIPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/27  16:28
 * 描    述
 * 修订历史：
 * ================================================
 */
@Route(path = WanAndroidARouterConstant.A_ROUTER_URL_WA_ACTIVITY_SYSTEM)
public class WASystemActivity extends FWBaseMvpActivity2<WASystemAPIPresenter> implements WASystemAPIContract.View {


    /**
     * 获取到的数据
     */
    private List<WASystemAPIBean.DataBean> dataBeanList = new ArrayList<>();


    // =============================================================================================


    @Override
    protected WASystemAPIPresenter createPresenter() {
        return new WASystemAPIPresenter();
    }

    @Override
    public BaseQuickAdapter getBaseQuickAdapter() {
        return new WASystemAdapter(dataBeanList);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void loadData() {
        frameworkSmartRefreshLayout.autoRefresh();
    }


    // =============================================================================================


    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        refreshLayoutType = REFRESH_LAYOUT_TYPE_LOADMORE;
        frameworkSmartRefreshLayout.finishLoadMoreWithNoMoreData();
        frameworkSmartRefreshLayout.finishLoadMore(true);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        refreshLayoutType = REFRESH_LAYOUT_TYPE_REFRESH;
        mPresenter.loadSystem();
    }


    // =============================================================================================


    @Override
    public void loadSuccess(WASystemAPIBean bean) {
        if (refreshLayoutType == REFRESH_LAYOUT_TYPE_REFRESH) {
            dataBeanList.clear();
        }
        // 添加获取到的数据
        dataBeanList.addAll(bean.getData());
        // 下啦刷新
        if (refreshLayoutType == REFRESH_LAYOUT_TYPE_REFRESH) {
            frameworkSmartRefreshLayout.finishRefresh();
            frameworkBaseQuickAdapter.notifyDataSetChanged();
        }
        // 当前没有加载更多
        frameworkSmartRefreshLayout.finishLoadMoreWithNoMoreData();

        frameworkSmartRefreshLayout.setEnableRefresh(false);
        frameworkSmartRefreshLayout.setEnableOverScrollDrag(true);
    }

    @Override
    public void loadFail() {
        ToastUtils.show("失败");
        frameworkSmartRefreshLayout.finishLoadMore(false);
        frameworkSmartRefreshLayout.finishRefresh(false);
    }
}

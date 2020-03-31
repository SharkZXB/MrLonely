package com.sharkz.wanandroid.navigation;

import androidx.annotation.NonNull;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hjq.toast.ToastUtils;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.sharkz.framework.base.activity.FWBaseMvpActivity2;
import com.sharkz.wanandroid.WanAndroidARouterConstant;
import com.sharkz.wanandroid.navigation.adapter.WANavigationAdapter;
import com.sharkz.wanandroid.navigation.bean.WANavigationBean;
import com.sharkz.wanandroid.navigation.mvp.WANavigationAPIContract;
import com.sharkz.wanandroid.navigation.mvp.WANavigationAPIPresenter;

import java.util.ArrayList;
import java.util.List;


/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/27  16:21
 * 描    述
 * 修订历史：
 * ================================================
 */
@Route(path = WanAndroidARouterConstant.A_ROUTER_URL_WA_ACTIVITY_NAVIGATION)
public class WANavigationActivity extends FWBaseMvpActivity2<WANavigationAPIPresenter> implements WANavigationAPIContract.View {


    /**
     * 获取到的数据
     */
    private List<WANavigationBean.DataBean> dataBeanList = new ArrayList<>();

    // =============================================================================================


    @Override
    protected WANavigationAPIPresenter createPresenter() {
        return new WANavigationAPIPresenter();
    }

    @Override
    public BaseQuickAdapter getBaseQuickAdapter() {
        return new WANavigationAdapter(dataBeanList);
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
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        refreshLayoutType = REFRESH_LAYOUT_TYPE_REFRESH;
        mPresenter.loadNavigation();
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        refreshLayoutType = REFRESH_LAYOUT_TYPE_LOADMORE;
        frameworkSmartRefreshLayout.finishLoadMoreWithNoMoreData();
        frameworkSmartRefreshLayout.finishLoadMore(true);
    }

    // =============================================================================================


    @Override
    public void loadSuccess(WANavigationBean navigationBean) {
        if (refreshLayoutType == REFRESH_LAYOUT_TYPE_REFRESH) {
            dataBeanList.clear();
        }
        // 添加获取到的数据
        dataBeanList.addAll(navigationBean.getData());
        // 下啦刷新
        if (refreshLayoutType == REFRESH_LAYOUT_TYPE_REFRESH) {
            frameworkSmartRefreshLayout.finishRefresh();
            frameworkBaseQuickAdapter.notifyDataSetChanged();
            return;
        }

        // 当前没有加载更多
        frameworkSmartRefreshLayout.finishLoadMoreWithNoMoreData();
    }

    @Override
    public void loadFailure() {
        ToastUtils.show("失败");
        frameworkSmartRefreshLayout.finishLoadMore(false);
        frameworkSmartRefreshLayout.finishRefresh(false);
    }
}

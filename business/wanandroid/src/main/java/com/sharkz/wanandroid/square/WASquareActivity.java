package com.sharkz.wanandroid.square;

import androidx.annotation.NonNull;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.immersionbar.ImmersionBar;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.sharkz.framework.base.activity.FWBaseMvpActivity2;
import com.sharkz.toast.module.ToastUtils;
import com.sharkz.wanandroid.R;
import com.sharkz.wanandroid.WanAndroidARouterConstant;
import com.sharkz.wanandroid.square.adapter.WASquareActivityAdapter;
import com.sharkz.wanandroid.square.mvp.WASquareAPIContract;
import com.sharkz.wanandroid.square.mvp.WASquareAPIPresenter;
import com.sharkz.wanandroid.square.mvp.WASquareBean;

import java.util.ArrayList;
import java.util.List;


/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/25  22:34
 * 描    述 广场界面
 * 修订历史：
 * ================================================
 */
@Route(path = WanAndroidARouterConstant.A_ROUTER_URL_WA_SQUARE_ACTIVITY)
public class WASquareActivity extends FWBaseMvpActivity2<WASquareAPIPresenter> implements WASquareAPIContract.View {


    private int pageNum = 0; // 加载更多计数器
    private List<WASquareBean.DataBean.DatasBean> dataBeanList = new ArrayList<>();  // 列表用到的数据

    // =============================================================================================


    @Override
    protected WASquareAPIPresenter createPresenter() {
        return new WASquareAPIPresenter();
    }

    @Override
    public BaseQuickAdapter getBaseQuickAdapter() {
        return new WASquareActivityAdapter(dataBeanList);
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
        // 加载数据
        mPresenter.loadSquare(pageNum);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        // 重置数据
        pageNum = 0;
        refreshLayoutType = REFRESH_LAYOUT_TYPE_REFRESH;
        // 加载数据
        mPresenter.loadSquare(pageNum);
    }


    // =============================================================================================


    @Override
    public void loadSuccess(WASquareBean bean) {
        pageNum++; // 只要成功了就++
        if (refreshLayoutType == REFRESH_LAYOUT_TYPE_REFRESH) {
            dataBeanList.clear();
        }
        // 添加获取到的数据
        dataBeanList.addAll(bean.getData().getDatas());
        // 下啦刷新
        if (refreshLayoutType == REFRESH_LAYOUT_TYPE_REFRESH) {
            frameworkSmartRefreshLayout.finishRefresh();
            frameworkBaseQuickAdapter.notifyDataSetChanged();
            return;
        }

        if (dataBeanList.size()>30){
            frameworkSmartRefreshLayout.finishLoadMoreWithNoMoreData();
            return;
        }

        // 加载更多
        if (refreshLayoutType == REFRESH_LAYOUT_TYPE_LOADMORE && bean.getData().getDatas().size() > 0) {
            frameworkSmartRefreshLayout.finishLoadMore();
            frameworkBaseQuickAdapter.notifyItemInserted(dataBeanList.size() + 1);
        } else {
            frameworkSmartRefreshLayout.finishLoadMoreWithNoMoreData();
        }

    }

    @Override
    public void loadFail() {
        ToastUtils.show("失败");
        frameworkSmartRefreshLayout.finishLoadMore(false);
        frameworkSmartRefreshLayout.finishRefresh(false);
    }

    /**
     * 状态栏设置
     */
    @Override
    public void setImmersionBar() {
        ImmersionBar.with(this)
                .statusBarDarkFont(true) //状态栏字体是深色，不写默认为亮色
                // .statusBarColor("#ffffff") // 设置状态栏颜色为白色
                //.titleBar(bar)    //解决状态栏和布局重叠问题，任选其一
                .titleBarMarginTop(rootLayout)     //解决状态栏和布局重叠问题，任选其一
                .navigationBarDarkIcon(true)  // 导航栏图标深色或亮色，只支持android o以上版本
                .transparentNavigationBar()
                .init();

//        ImmersionBar.with(this)
//                .transparentBar()
//                .init();
    }


    @Override
    public void setIsNavigationBarOverlap() {
        // super.setIsNavigationBarOverlap();
        mSwipeBackHelper.setIsNavigationBarOverlap(true);
    }

}

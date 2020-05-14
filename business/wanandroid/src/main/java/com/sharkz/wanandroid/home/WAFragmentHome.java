package com.sharkz.wanandroid.home;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.sharkz.framework.base.fragment.FWBaseMvpFragment2;
import com.sharkz.recyclerview.SectionSpacesItemDecoration1;
import com.sharkz.wanandroid.R;
import com.sharkz.wanandroid.WanAndroidARouterConstant;
import com.sharkz.wanandroid.home.adapter.WAHomeAdapter;
import com.sharkz.wanandroid.home.agentmodel.WAHomeBannerAgentModel;
import com.sharkz.wanandroid.home.agentmodel.WAModulesNavigationAgentModel;
import com.sharkz.wanandroid.home.bean.WAHomeArticleListBean;
import com.sharkz.wanandroid.home.bean.WAHomeBannerBean;
import com.sharkz.wanandroid.home.mvp.WAHomeAPIContract;
import com.sharkz.wanandroid.home.mvp.WAHomeAPIPresenter;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020-01-11  17:27
 * 描    述 Demo 首页
 * 修订历史：
 * ================================================
 */
@Route(path = WanAndroidARouterConstant.A_ROUTER_URL_WA_FRAGMENT_HOME)
public class WAFragmentHome extends FWBaseMvpFragment2<WAHomeAPIPresenter> implements WAHomeAPIContract.View {

    private int pageNum = 0; // 加载更多计数器
    private List<WAHomeArticleListBean.DataBean.DatasBean> homeArticleListBeanList = new ArrayList<>();  // 首页文章数据
    private Banner bannerView;  // BannerView 拼接到列表的

    // =============================================================================================


    /**
     * 如果你需要考虑更好的体验，可以这么操作
     */
    @Override
    public void onStart() {
        super.onStart();
        bannerView.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        bannerView.stop();
    }

    @Override
    protected WAHomeAPIPresenter createPresenter() {
        return new WAHomeAPIPresenter();
    }

    @Override
    protected void onCreateAfterView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {

    }

    @Override
    protected void initView(View view) {
        super.initView(view);

        // 导航模块
        frameworkBaseQuickAdapter.addHeaderView(new WAModulesNavigationAgentModel(getContext()).getViewRoot(), 0);

        // BannerView
        bannerView = new WAHomeBannerAgentModel(getContext()).getBannerView();
        frameworkBaseQuickAdapter.addHeaderView(bannerView, 0);

        // 小火箭
        // floatingActionButton.setVisibility(View.VISIBLE);
        ColorStateList colorStateList = ContextCompat.getColorStateList(getContext(), R.color.fw_bg_1);
        floatingActionButton.setBackgroundTintMode(PorterDuff.Mode.SRC_ATOP);
        floatingActionButton.setBackgroundTintList(colorStateList);
    }

    @Override
    public void setRecyclerViewAdapter() {
        super.setRecyclerViewAdapter();
        frameworkRecyclerView.addItemDecoration(new SectionSpacesItemDecoration1(20));
    }

    @Override
    public BaseQuickAdapter getBaseQuickAdapter() {
        return new WAHomeAdapter(homeArticleListBeanList);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {
        frameworkRecyclerView.addOnScrollListener(new OnScrollListener() {

            //用来标记是否正在向最后一个滑动
            boolean isSlidingToLast = false;

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                // 当不滚动时
//                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
//                    // 获取最后一个完全显示的ItemPosition
//                    int lastVisibleItem = manager.findLastCompletelyVisibleItemPosition();
//                    int totalItemCount = manager.getItemCount();
//
//                    // 判断是否滚动到底部，并且是向右滚动
//                    if (lastVisibleItem == (totalItemCount - 1) && isSlidingToLast) {
//                        //加载更多功能的代码
//                    }
//                }
                int firstItem = manager.findFirstCompletelyVisibleItemPosition();
                if (firstItem >= 2) {
                    floatingActionButton.setVisibility(View.VISIBLE);
                } else {
                    floatingActionButton.setVisibility(View.GONE);
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //dx用来判断横向滑动方向，dy用来判断纵向滑动方向
                if (dx > 0) {
                    //大于0表示正在向右滚动
                    isSlidingToLast = true;
                } else {
                    //小于等于0表示停止或向左滚动
                    isSlidingToLast = false;
                }
            }
        });
    }

    @Override
    protected void loadData() {
        frameworkSmartRefreshLayout.autoRefresh();
    }

    @Override
    public void onFloatingActionButton() {
        super.onFloatingActionButton();
        frameworkRecyclerView.scrollToPosition(0);
    }

    // =============================================================================================


    // =============================================================================================

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        // 重置数据
        pageNum = 0;
        refreshLayoutType = REFRESH_LAYOUT_TYPE_REFRESH;
        // 加载数据
        mPresenter.loadHomeArticle(pageNum);
        mPresenter.loadHomeBanner();
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        refreshLayoutType = REFRESH_LAYOUT_TYPE_LOADMORE;
        // 加载数据
        mPresenter.loadHomeArticle(pageNum);
    }

    // =============================================================================================

    @Override
    public void homeArticleSuccess(WAHomeArticleListBean WAHomeArticleListBean) {
        pageNum++; // 只要成功了就++
        if (refreshLayoutType == REFRESH_LAYOUT_TYPE_REFRESH) {
            homeArticleListBeanList.clear();
        }

        // 添加获取到的数据
        homeArticleListBeanList.addAll(WAHomeArticleListBean.getData().getDatas());

        // 下啦刷新
        if (refreshLayoutType == REFRESH_LAYOUT_TYPE_REFRESH) {
            frameworkSmartRefreshLayout.finishRefresh();
            frameworkBaseQuickAdapter.notifyDataSetChanged();
            return;
        }

        // 加载更多
        if (refreshLayoutType == REFRESH_LAYOUT_TYPE_LOADMORE && WAHomeArticleListBean.getData().getDatas().size() > 0) {
            frameworkSmartRefreshLayout.finishLoadMore();
            frameworkBaseQuickAdapter.notifyItemInserted(homeArticleListBeanList.size() + 1);
        } else {
            frameworkSmartRefreshLayout.finishLoadMoreWithNoMoreData();
        }
    }

    @Override
    public void homeBannerSuccess(WAHomeBannerBean WAHomeBannerBean) {
        bannerView.setDatas(WAHomeBannerBean.getData());
        bannerView.getViewPager2().setCurrentItem(1); // 这个修复设置数据之后banner不是第一个数据
    }

    @Override
    public void homeArticleTopSuccess() {

    }

    @Override
    public void homeArticleFailure() {
        Log.i(TAG, "loginFailure: 获取数据失败");
        frameworkSmartRefreshLayout.finishLoadMore(false);
        frameworkSmartRefreshLayout.finishRefresh(false);
    }

}

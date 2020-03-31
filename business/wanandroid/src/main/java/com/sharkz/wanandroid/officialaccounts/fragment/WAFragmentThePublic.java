package com.sharkz.wanandroid.officialaccounts.fragment;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.tabs.TabLayout;
import com.sharkz.framework.base.fragment.FWBaseMvpFragment;
import com.sharkz.framework.base.fragment.FWLazyPagerAdapter;
import com.sharkz.wanandroid.R;
import com.sharkz.wanandroid.WanAndroidARouterConstant;
import com.sharkz.wanandroid.officialaccounts.bean.WAChaptersListBean;
import com.sharkz.wanandroid.officialaccounts.mvp.WAThePublicAPIContract;
import com.sharkz.wanandroid.officialaccounts.mvp.WAThePublicAPIPresenter;

import java.util.ArrayList;
import java.util.List;


/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020-01-11  17:27
 * 描    述 公众号
 * 修订历史：
 * ================================================
 */
@Route(path = WanAndroidARouterConstant.A_ROUTER_URL_WA_FRAGMENT_OFFICIAL_ACCOUNTS)
public class WAFragmentThePublic extends FWBaseMvpFragment<WAThePublicAPIPresenter> implements WAThePublicAPIContract.View {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    // =============================================================================================

    @Override
    protected WAThePublicAPIPresenter createPresenter() {
        return new WAThePublicAPIPresenter();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_the_public_layout;
    }

    @Override
    protected void initView(View view) {
        viewPager=view.findViewById(R.id.viewPager);
        tabLayout=view.findViewById(R.id.tabLayout);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void loadData() {
        mPresenter.loadChaptersList();
    }


    // =============================================================================================


    @Override
    public void loadChaptersListSuccess(WAChaptersListBean WAChaptersListBean) {
        List<Fragment> fragmentList = new ArrayList<>();
        List<String> pageTitleList= new ArrayList<>();
        for (WAChaptersListBean.DataBean dataBean: WAChaptersListBean.getData()) {
            pageTitleList.add(dataBean.getName());
            fragmentList.add(WAThePublicListFragment.getInstance(dataBean.getId()));
        }
        FWLazyPagerAdapter adapter = new FWLazyPagerAdapter(getChildFragmentManager(),fragmentList,pageTitleList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}

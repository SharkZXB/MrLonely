package com.sharkz.wanandroid.officialaccounts;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.tabs.TabLayout;
import com.sharkz.framework.base.activity.FWBaseMvpActivity;
import com.sharkz.framework.base.fragment.FWLazyPagerAdapter;
import com.sharkz.wanandroid.R;
import com.sharkz.wanandroid.WanAndroidARouterConstant;
import com.sharkz.wanandroid.officialaccounts.bean.WAChaptersListBean;
import com.sharkz.wanandroid.officialaccounts.fragment.WAThePublicListFragment;
import com.sharkz.wanandroid.officialaccounts.mvp.WAThePublicAPIContract;
import com.sharkz.wanandroid.officialaccounts.mvp.WAThePublicAPIPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/26  11:53
 * 描    述 公众号 界面
 * 修订历史：
 * ================================================
 */
@Route(path = WanAndroidARouterConstant.A_ROUTER_URL_WA_ACTIVITY_OFFICIAL_ACCOUNTS)
public class WAOfficialAccountsActivity extends FWBaseMvpActivity<WAThePublicAPIPresenter> implements WAThePublicAPIContract.View {


    private TabLayout tabLayout;
    private ViewPager viewPager;

    // =============================================================================================

    @Override
    protected WAThePublicAPIPresenter createPresenter() {
        return new WAThePublicAPIPresenter();
    }

    @Override
    public int setRealLayout() {
        return R.layout.activity_official_accounts;
    }

    @Override
    public void initView() {
        viewPager = bind(R.id.viewPager);
        tabLayout = bind(R.id.tabLayout);
    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void loadData() {
        mPresenter.loadChaptersList();
    }

    // =============================================================================================


    @Override
    public void loadChaptersListSuccess(WAChaptersListBean WAChaptersListBean) {
        List<Fragment> fragmentList = new ArrayList<>();
        List<String> pageTitleList = new ArrayList<>();
        for (WAChaptersListBean.DataBean dataBean : WAChaptersListBean.getData()) {
            pageTitleList.add(dataBean.getName());
            fragmentList.add(WAThePublicListFragment.getInstance(dataBean.getId()));
        }
        FWLazyPagerAdapter adapter = new FWLazyPagerAdapter(getSupportFragmentManager(), fragmentList, pageTitleList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}

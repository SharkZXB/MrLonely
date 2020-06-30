package com.sharkz.wanandroid.project;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.tabs.TabLayout;
import com.sharkz.framework.base.activity.FWBaseMvpActivity;
import com.sharkz.framework.base.fragment.FWLazyPagerAdapter;
import com.sharkz.toast.module.ToastUtils;
import com.sharkz.wanandroid.R;
import com.sharkz.wanandroid.WanAndroidARouterConstant;
import com.sharkz.wanandroid.project.fragment.WAProjectListFragment;
import com.sharkz.wanandroid.project.mvp.WAProjectAPIContract;
import com.sharkz.wanandroid.project.mvp.WAProjectAPIPresenter;
import com.sharkz.wanandroid.project.bean.WAProjectBean;

import java.util.ArrayList;
import java.util.List;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/27  14:47
 * 描    述
 * 修订历史：
 * ================================================
 */
@Route(path = WanAndroidARouterConstant.A_ROUTER_URL_WA_ACTIVITY_PROJECT)
public class WAProjectActivity extends FWBaseMvpActivity<WAProjectAPIPresenter> implements WAProjectAPIContract.View {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    // =============================================================================================


    @Override
    protected WAProjectAPIPresenter createPresenter() {
        return new WAProjectAPIPresenter();
    }

    @Override
    public int setRealLayout() {
        return R.layout.activity_w_a_project;
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
        mPresenter.loadProject();
    }


    // =============================================================================================


    @Override
    public void loadSuccess(WAProjectBean bean) {
        List<Fragment> fragmentList = new ArrayList<>();
        List<String> pageTitleList = new ArrayList<>();

        for (WAProjectBean.DataBean b : bean.getData()) {
            pageTitleList.add(b.getName());
            fragmentList.add(WAProjectListFragment.getInstance(b.getId()));
        }

        FWLazyPagerAdapter adapter = new FWLazyPagerAdapter(getSupportFragmentManager(), fragmentList, pageTitleList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void loadFail() {
        ToastUtils.show("获取数据 失败");
    }
}

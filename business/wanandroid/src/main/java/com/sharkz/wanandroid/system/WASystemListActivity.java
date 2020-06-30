package com.sharkz.wanandroid.system;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.tabs.TabLayout;
import com.sharkz.framework.base.activity.FWBaseSimpleActivity;
import com.sharkz.framework.base.fragment.FWLazyPagerAdapter;
import com.sharkz.wanandroid.R;
import com.sharkz.wanandroid.WanAndroidARouterConstant;
import com.sharkz.wanandroid.officialaccounts.bean.WAChaptersListBean;
import com.sharkz.wanandroid.officialaccounts.fragment.WAThePublicListFragment;
import com.sharkz.wanandroid.system.bean.WASystemAPIBean;
import com.sharkz.wanandroid.system.fragment.WASystemListFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/28  14:12
 * 描    述
 * 修订历史：
 * ================================================
 */
@Route(path = WanAndroidARouterConstant.A_ROUTER_URL_WA_ACTIVITY_SYSTEM_LIST)
public class WASystemListActivity extends FWBaseSimpleActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;

    private int index;                           // 当前下标
    private WASystemAPIBean.DataBean item;       // 传递过来的数据

    // =============================================================================================


    @Override
    public void getIntentData() {
        super.getIntentData();
        index = getIntent().getIntExtra("index", 0);
        item = (WASystemAPIBean.DataBean) getIntent().getSerializableExtra("Item");
    }

    @Override
    public int setRealLayout() {
        return R.layout.activity_w_a_system_list;
    }

    @Override
    public void initView() {
        viewPager = bind(R.id.viewPager);
        tabLayout = bind(R.id.tabLayout);
    }

    @Override
    public void initData() {

        if (item != null) {
            List<Fragment> fragmentList = new ArrayList<>();
            List<String> pageTitleList = new ArrayList<>();

            for (WASystemAPIBean.DataBean.ChildrenBean dataBean : item.getChildren()) {
                pageTitleList.add(dataBean.getName());
                fragmentList.add(WASystemListFragment.getInstance(dataBean.getId()));
            }

            FWLazyPagerAdapter adapter = new FWLazyPagerAdapter(getSupportFragmentManager(), fragmentList, pageTitleList);
            viewPager.setAdapter(adapter);
            tabLayout.setupWithViewPager(viewPager);

            // 设置当前选中的是第几个
            viewPager.setCurrentItem(index);

        }

    }

    @Override
    public void setListener() {

    }

    @Override
    public void loadData() {

    }

}

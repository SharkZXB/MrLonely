package com.sharkz.mrlonely;

import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.immersionbar.ImmersionBar;
import com.sharkz.coolview.NoScrollViewPager;
import com.sharkz.coolview.bottomtabbar.BottomTabBarView;
import com.sharkz.coolview.bottomtabbar.Tab;
import com.sharkz.framework.base.fragment.FWLazyPagerAdapter;
import com.sharkz.tabmine.FragmentMine;
import com.sharkz.tabmusic.FragmentMusic;
import com.sharkz.tabvideo.FragmentVideo;
import com.sharkz.wanandroid.WanAndroidModuleService;

import java.util.ArrayList;
import java.util.List;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/16  17:05
 * 描    述 代理MainActivity 界面的显示
 * 修订历史：通过实现LifecycleObserver接口，然后在相应的方法上面添加注解@OnLifecycleEvent(Lifecycle.Event.XXX)即可。
 * 实际上，这就是一个观察者。当执行到某个生命周期时，会通知观察者执行对应的方法。
 * ================================================
 */
public class MainActivityAgent implements LifecycleObserver {

    private ConstraintLayout layout;
    private MainActivity mainActivity;
    private BottomTabBarView bottomTabBarView;
    private NoScrollViewPager noScrollViewPager;

    public MainActivityAgent(MainActivity mainActivity, ConstraintLayout layout) {
        this.mainActivity = mainActivity;
        this.layout = layout;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {

        ImmersionBar.with(mainActivity)
                .statusBarDarkFont(true) //状态栏字体是深色，不写默认为亮色
                //.titleBar(layout)    //解决状态栏和布局重叠问题，任选其一
                .titleBarMarginTop(layout)     //解决状态栏和布局重叠问题，任选其一
                .navigationBarDarkIcon(true)  // 导航栏图标深色或亮色，只支持android o以上版本
                .navigationBarColor(R.color.white)
                .init();

        bottomTabBarView = layout.findViewById(R.id.bottomTabBarView);
        noScrollViewPager = layout.findViewById(R.id.noScrollViewPager);
        noScrollViewPager.setOffscreenPageLimit(4);
        List<Fragment> fragmentList = new ArrayList<>();

        WanAndroidModuleService service = ARouter.getInstance().navigation(WanAndroidModuleService.class);
        if (service != null) {
            fragmentList.add(service.getHomeFragment());
        }
        fragmentList.add(new FragmentMusic());
        fragmentList.add(new FragmentVideo());
        fragmentList.add(new FragmentMine());

        noScrollViewPager.setAdapter(new FWLazyPagerAdapter(mainActivity.getSupportFragmentManager(), fragmentList));

        List<Tab> tabs = new ArrayList<>();
        tabs.add(new Tab(mainActivity, "玩安卓", R.mipmap.tab2_home_off, R.mipmap.tab2_home_on));
        tabs.add(new Tab(mainActivity, "音乐", R.mipmap.tab2_home_off, R.mipmap.tab2_home_on));
        tabs.add(new Tab(mainActivity, "视频", R.mipmap.tab2_home_off, R.mipmap.tab2_home_on));
        tabs.add(new Tab(mainActivity, "我的", R.mipmap.tab2_home_off, R.mipmap.tab2_home_on));
        bottomTabBarView.setTab(tabs)
                .setOnTabChangeListener(new BottomTabBarView.OnTabChangeListener() {
                    @Override
                    public void onTabChanged(View v, int index) {
                        // Log.i(">>>", "onTabChanged: " + index);
                        // tabTwoType.setUnreadNum(2, index - 1);
                        noScrollViewPager.setCurrentItem(index);
                    }
                });

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void onAny() {
        // 这个每次都执行
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {

    }

}

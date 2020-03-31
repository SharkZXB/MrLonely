package com.just.agentweb.guide;

import android.os.Bundle;

import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.sharkz.framework.base.activity.FWBaseBarActivity;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/30  13:08
 * 描    述 引导页 主界面
 * 修订历史：
 * ================================================
 */
@Route(path = GuideModuleConstant.A_ROUTER_URL_GUIDE_ACTIVITY_Guide)
public class GuideActivity extends FWBaseBarActivity implements ViewPager.OnPageChangeListener {


    private boolean isScrolled;
    private ViewPager viewPager;


    // =============================================================================================


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        // 初始化数据
        init();
    }

    @Override
    public void setSwipeBackEnable() {
        if (mSwipeBackHelper != null) {
            mSwipeBackHelper.setSwipeBackEnable(false);
        }
    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
    }

    @Override
    public void setIsNavigationBarOverlap() {
        // super.setIsNavigationBarOverlap();
        mSwipeBackHelper.setIsNavigationBarOverlap(true);
    }

    @Override
    public void setImmersionBar() {
        ImmersionBar
                .with(this)
                .transparentBar()
                .hideBar(BarHide.FLAG_HIDE_BAR)
                .init();
    }

    // =============================================================================================


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {
        switch (i) {
            case ViewPager.SCROLL_STATE_DRAGGING:
                isScrolled = false;
                break;
            case ViewPager.SCROLL_STATE_SETTLING:
                isScrolled = true;
                break;
            case ViewPager.SCROLL_STATE_IDLE:
                if (viewPager.getCurrentItem() == viewPager.getAdapter().getCount() - 1 && !isScrolled) {
                    //滑到最后一个页面之后的继续操作
                    finish();
                }
                if (viewPager.getCurrentItem() == 0 && !isScrolled) {
                    //滑到第一个页面之后的继续操作
                }
                isScrolled = true;
                break;
        }

    }


    // =============================================================================================


    private void init() {
        viewPager = bind(R.id.viewPager);
        GuideActivityAdapter adapter = new GuideActivityAdapter(this, null);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
    }


}

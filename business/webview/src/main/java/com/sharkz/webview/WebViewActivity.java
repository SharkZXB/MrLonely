package com.sharkz.webview;

import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.immersionbar.ImmersionBar;
import com.sharkz.framework.base.activity.FWBaseDarkModeActivity;
import com.sharkz.webview.common.FragmentKeyDown;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/17  23:16
 * 描    述 Demo 所有的 WebView 都进入这个界面
 * 修订历史：
 * ================================================
 */
@Route(path = ARouterConstant.WEB_VIEW_ACTIVITY)
public class WebViewActivity extends FWBaseDarkModeActivity {

    private WebViewFragment mAgentWebFragment;
    private ConstraintLayout rootLayout;


    // =============================================================================================


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wv_activity_web_view);

        rootLayout = findViewById(R.id.rootLayout);
        setImmersionBar();

        String uriStr = getIntent().getStringExtra(ARouter.RAW_URI);
        Bundle bundle = new Bundle();
        bundle.putString(AgentWebFragment.URL_KEY, uriStr);
        mAgentWebFragment = WebViewFragment.addAgentWebFragment(getSupportFragmentManager(), R.id.fl, bundle);
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        AgentWebFragment mAgentWebFragment = this.mAgentWebFragment;
        if (mAgentWebFragment != null) {
            FragmentKeyDown mFragmentKeyDown = mAgentWebFragment;
            if (mFragmentKeyDown.onFragmentKeyDown(keyCode, event)) {
                return true;
            } else {
                return super.onKeyDown(keyCode, event);
            }
        }
        return super.onKeyDown(keyCode, event);
    }


    // =============================================================================================


    /**
     * 状态栏设置
     */
    private void setImmersionBar() {
        ImmersionBar.with(this)
                .statusBarDarkFont(true) //状态栏字体是深色，不写默认为亮色
                //.titleBar(rootLayout)    //解决状态栏和布局重叠问题，任选其一
                .titleBarMarginTop(rootLayout)     //解决状态栏和布局重叠问题，任选其一
                .navigationBarDarkIcon(true)
                .navigationBarColor(R.color.fw_transparent)
                .init();
    }

}

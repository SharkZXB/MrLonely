package com.sharkz.webview;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.FragmentManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/24  21:06
 * 描    述 服务接口实现类
 * 修订历史：
 * ================================================
 */
@Route(path = ARouterConstant.A_ROUTER_URL_WEB_VIEW_SERVICE_IMPL)
public class WebViewServiceImpl implements WebViewService {

    @Override
    public void init(Context context) {

    }

    @Override
    public WebViewFragment getWebViewFragment(Bundle bundle) {
        return WebViewFragment.getInstance(bundle);
    }

    @Override
    public WebViewFragment addAgentWebFragment(FragmentManager mFragmentManager, int containerId, Bundle bundle) {
        return WebViewFragment.addAgentWebFragment(mFragmentManager, containerId, bundle);
    }

    @Override
    public void jump2WebViewActivity(String url) {
        ARouter.getInstance().build(ARouterConstant.WEB_VIEW_ACTIVITY).withString(ARouter.RAW_URI, url).navigation();
    }
}

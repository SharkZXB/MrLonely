package com.sharkz.wanandroid;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/25  18:30
 * 描    述
 * 修订历史：
 * ================================================
 */
@Route(path = WanAndroidARouterConstant.A_ROUTER_URL_WA_SERVICE_IMPL)
public class WanAndroidModuleServiceImpl implements WanAndroidModuleService {

    @Override
    public void init(Context context) {

    }

    @Override
    public Fragment getHomeFragment() {
        return (Fragment) ARouter.getInstance().build(WanAndroidARouterConstant.A_ROUTER_URL_WA_FRAGMENT_HOME).navigation();
    }

    @Override
    public Fragment getOfficialAccountsFragment() {
        return (Fragment) ARouter.getInstance().build(WanAndroidARouterConstant.A_ROUTER_URL_WA_FRAGMENT_OFFICIAL_ACCOUNTS).navigation();
    }

}

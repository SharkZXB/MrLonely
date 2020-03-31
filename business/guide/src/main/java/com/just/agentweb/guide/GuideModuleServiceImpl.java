package com.just.agentweb.guide;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/30  13:10
 * 描    述 当前 Module 服务 实现类
 * 修订历史：
 * ================================================
 */
@Route(path = GuideModuleConstant.A_ROUTER_URL_GUIDE_SERVICE_IMPL)
public class GuideModuleServiceImpl implements GuideModuleService {

    @Override
    public void init(Context context) {

    }

    @Override
    public void navigationGuideActivity() {
        ARouter.getInstance().build(GuideModuleConstant.A_ROUTER_URL_GUIDE_ACTIVITY_Guide).navigation();
    }

}

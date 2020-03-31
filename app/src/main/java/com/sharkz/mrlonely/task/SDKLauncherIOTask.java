package com.sharkz.mrlonely.task;

import android.app.Application;

import com.sharkz.applauncher.executor.Schedulers;
import com.sharkz.applauncher.task.LaunchTask;
import com.sharkz.arouter.Init_ARouterModule;
import com.sharkz.mrlonely.BuildConfig;
import com.sharkz.smartrefreshlayout.Init_SmartRefreshLayoutModule;
import com.sharkz.swipebacklayout.Init_SwipeBackLayout;
import com.sharkz.tool.kit.LeakCanaryTool;
import com.sharkz.tool.kit.PreferenceUtils;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/26  16:59
 * 描    述 子线程执行的任务
 * 修订历史：
 * ================================================
 */
public class SDKLauncherIOTask extends LaunchTask {

    private Application application;

    public SDKLauncherIOTask(Application application) {
        this.application = application;
    }

    @Override
    protected void call() {
        Init_SwipeBackLayout.init(application);                     // 滑动返回
        Init_SmartRefreshLayoutModule.init();                       // 下啦刷新
        Init_ARouterModule.init(application, BuildConfig.DEBUG);    // 路由
        PreferenceUtils.initSP(application);                        // SP
        LeakCanaryTool.setupLeakCanary(application);                // 内存泄漏
    }

    @Override
    public void callBackData(Object object) {

    }

    @Override
    public Schedulers runOn() {
        return Schedulers.IO;
    }
}

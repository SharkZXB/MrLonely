package com.sharkz.mrlonely;

import com.didichuxing.doraemonkit.DoraemonKit;
import com.sharkz.applauncher.AppLauncher;
import com.sharkz.applauncher.listener.IdleHandler;
import com.sharkz.framework.FrameworkApplication;
import com.sharkz.mrlonely.task.AsyncLoadSDKListener;
import com.sharkz.mrlonely.task.SDKLauncherIOTask;
import com.sharkz.mrlonely.task.SDKLauncherUITask;
import com.sharkz.tool.kit.LoggerTool;


/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020-01-11  18:05
 * 描    述
 * 修订历史：
 * ================================================
 */
public class App extends FrameworkApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        initInHostProcess();
    }


    // =============================================================================================


    /**
     * 下面的是在主进程中初始化的
     */
    private void initInHostProcess() {
        // TODO 这两个必须在前面初始化
        DoraemonKit.install(application);
        LoggerTool.getInstance().init();

        // 加载SDK
        new AppLauncher.Builder()
                .addHeadTask(new SDKLauncherUITask(this))
                .addTask(new SDKLauncherIOTask(this))
                .idleHandler(new IdleHandler() {
                    @Override
                    public void onIdle() {
                        isSDKAsyncComplete(true);
                        if (sdkListener != null) {
                            sdkListener.onComplete();
                        }
                    }
                }).start();
    }


    // =============================================================================================

    public static boolean isSDKAsyncComplete = false;

    private static AsyncLoadSDKListener sdkListener;

    public static void setAsyncLoadSDKListener(AsyncLoadSDKListener sdkListener) {
        App.sdkListener = sdkListener;
    }

    public synchronized void isSDKAsyncComplete(boolean complete) {
        isSDKAsyncComplete = complete;
    }

}

/*

 资源文件命名规则 moduleName-

 */

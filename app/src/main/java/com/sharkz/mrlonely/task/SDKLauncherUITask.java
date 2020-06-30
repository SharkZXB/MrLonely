package com.sharkz.mrlonely.task;

import android.app.Application;

import com.sharkz.applauncher.executor.Schedulers;
import com.sharkz.applauncher.task.LaunchTask;
import com.sharkz.toast.module.ToastUtils;
import com.sharkz.tool.Init_Tool;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/26  17:26
 * 描    述 UI线程执行的任务
 * 修订历史：
 * ================================================
 */
public class SDKLauncherUITask extends LaunchTask {

    private Application application;

    public SDKLauncherUITask(Application application) {
        this.application = application;
    }

    @Override
    protected void call() {
        Init_Tool.application = application;    // 将上下文传入工具类
        ToastUtils.init(application);           // Toast
    }

    @Override
    public void callBackData(Object object) {

    }

    @Override
    public Schedulers runOn() {
        return Schedulers.MAIN;
    }
}

package com.sharkz.mrlonely;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.just.agentweb.guide.GuideModuleService;
import com.sharkz.datastorage.sp.PreferenceUtils;
import com.sharkz.mrlonely.task.AsyncLoadSDKListener;


/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/26  10:09
 * 描    述 启动页
 * 修订历史：
 * ================================================
 */
public class SplashActivity extends AppCompatActivity implements AsyncLoadSDKListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_splash);

        if(2>3){
            return;
        }

        // 回调注册 接受
        if (!App.isSDKAsyncComplete) {
            App.setAsyncLoadSDKListener(this);
        } else {
            gotoJump();
        }
    }


    @Override
    public void onComplete() {
        gotoJump();
    }


    /**
     * 界面 跳转
     */
    private void gotoJump() {

        if (PreferenceUtils.getBoolean(AppConstant.IS_SHOW_GUIDE, true)) {

            // 设置标示
            PreferenceUtils.putBoolean(AppConstant.IS_SHOW_GUIDE, false);
            // 界面跳转
            GuideModuleService guideModuleService = ARouter.getInstance().navigation(GuideModuleService.class);
            if (guideModuleService != null) {
                // 这里的处理逻辑是 一次性开启两个Activity GuideActivity finish 回调Main
                jump2Main();
                guideModuleService.navigationGuideActivity();
            }
        } else {
            jump2Main();
        }

        // 下面是延时模拟(广告)
//        HandlerUtil.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }, 1500);
    }

    /**
     * 跳转到主界面
     */
    private void jump2Main() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }

}

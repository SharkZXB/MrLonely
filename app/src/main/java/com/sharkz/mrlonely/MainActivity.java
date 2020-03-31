package com.sharkz.mrlonely;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020-01-11  16:16
 * 描    述 当前壳工程 业务逻辑在 business 文件夹下 --> Tab Module 可以当读新建项目 组件化开发 ，节省编译时间 互不干扰
 * 修订历史：
 * ================================================
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 根布局
        ConstraintLayout layout = findViewById(R.id.layout);
        // 观察者
        MainActivityAgent mainActivityAgent = new MainActivityAgent(this, layout);
        getLifecycle().addObserver(mainActivityAgent);
    }


    /**
     * App 热启动方式，实现应用程序秒开效果
     */
    @Override
    public void onBackPressed() {
        //直接返回桌面 ( Activity只执行onStop ）
        if (isStartHome()) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            startActivity(intent);
        } else {
            super.onBackPressed(); // ( Activity将执行onDestory ）
        }
    }

    /**
     * 这里可以设置成可配置的
     */
    private boolean isStartHome() {
        return true;
    }
}

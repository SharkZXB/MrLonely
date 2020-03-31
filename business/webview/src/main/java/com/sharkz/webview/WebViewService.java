package com.sharkz.webview;

import android.os.Bundle;

import androidx.fragment.app.FragmentManager;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/24  21:03
 * 描    述 ARouter 服务接口 供外界调用
 * 修订历史：
 * ================================================
 */
public interface WebViewService extends IProvider {

    /**
     * 获取到当前Fragment实例
     * @param bundle 传入的数据
     */
    WebViewFragment getWebViewFragment(Bundle bundle);

    /**
     * 将当前Fragment添加到布局中
     * @param mFragmentManager manager
     * @param containerId      容器ID
     * @param bundle           传入的数据
     */
    WebViewFragment addAgentWebFragment(FragmentManager mFragmentManager, int containerId, Bundle bundle);

    /**
     * 直接条状到 WebViewActivity
     * @param url url
     */
    void jump2WebViewActivity(String url);

}

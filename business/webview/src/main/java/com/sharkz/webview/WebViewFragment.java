package com.sharkz.webview;

import android.os.Bundle;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/24  21:09
 * 描    述 这个是个例子 当前可以自定义
 * 修订历史：
 * ================================================
 */
public class WebViewFragment extends AgentWebFragment {

    /**
     * 将Fragment 添加到 Activity中
     *
     * @param mFragmentManager manager
     * @param containerId      容器ViewID
     * @param bundle           传入的数据
     * @return AgentWebFragment 实例
     */
    public static WebViewFragment addAgentWebFragment(FragmentManager mFragmentManager, int containerId, Bundle bundle) {
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        WebViewFragment mAgentWebFragment = WebViewFragment.getInstance(bundle);
        ft.add(containerId, mAgentWebFragment, WebViewFragment.class.getName());
        ft.commit();
        return mAgentWebFragment;
    }

    /**
     * 获取当前实例
     *
     * @param bundle 传入的数据
     * @return AgentWebFragment 实例
     */
    public static WebViewFragment getInstance(Bundle bundle) {
        WebViewFragment mAgentWebFragment = new WebViewFragment();
        if (bundle != null) {
            mAgentWebFragment.setArguments(bundle);
        }
        return mAgentWebFragment;
    }

}

package com.sharkz.wanandroid;

import androidx.fragment.app.Fragment;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/25  18:10
 * 描    述
 * 修订历史：
 * ================================================
 */
public interface WanAndroidModuleService extends IProvider {

    /**
     * @return 获取首页的Fragment
     */
    Fragment getHomeFragment();

    /**
     * 获取公众号Fragment
     */
    Fragment getOfficialAccountsFragment();


}

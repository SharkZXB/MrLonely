package com.sharkz.tabvideo;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sharkz.toast.module.ToastUtils;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/25  21:10
 * 描    述
 * 修订历史：
 * ================================================
 */
@Route(path = ARouterConstant.A_ROUTER_URL_VIDEO_SERVICE)
public class VideoServiceImpl implements VideoService {

    @Override
    public void init(Context context) {

    }

    @Override
    public void sayHello() {
        ToastUtils.show("服务调用的");
    }

}

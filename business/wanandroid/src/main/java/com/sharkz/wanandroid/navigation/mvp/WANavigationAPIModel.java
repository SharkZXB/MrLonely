package com.sharkz.wanandroid.navigation.mvp;

import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWBaseModel;
import com.sharkz.framework.mvp.FWIView;
import com.sharkz.okgo.sdk.OkGo;
import com.sharkz.wanandroid.navigation.bean.WANavigationBean;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/28  12:01
 * 描    述
 * 修订历史：
 * ================================================
 */
public class WANavigationAPIModel extends FWBaseModel implements WANavigationAPIContract.Model {

    public WANavigationAPIModel(FWIView iView) {
        super(iView);
    }

    @Override
    public void loadNavigation(FWSimpleJsonCallBack<WANavigationBean> callback) {
        OkGo.<WANavigationBean>get(WANavigationAPI.navi)
                .tag(iView.get())
                .execute(callback);
    }
}

package com.sharkz.wanandroid.navigation.mvp;

import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWIModel;
import com.sharkz.framework.mvp.FWIPresenter;
import com.sharkz.framework.mvp.FWIView;
import com.sharkz.wanandroid.navigation.bean.WANavigationBean;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/27  16:21
 * 描    述
 * 修订历史：
 * ================================================
 */
public interface WANavigationAPIContract {

    interface View extends FWIView {
        void loadSuccess(WANavigationBean navigationBean);

        void loadFailure();
    }

    interface Presenter extends FWIPresenter<WANavigationAPIContract.View> {
        void loadNavigation();
    }

    interface Model extends FWIModel {
        void loadNavigation(FWSimpleJsonCallBack<WANavigationBean> callback);
    }

}

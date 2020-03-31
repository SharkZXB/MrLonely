package com.sharkz.tabvideo.mvp;

import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWIModel;
import com.sharkz.framework.mvp.FWIPresenter;
import com.sharkz.framework.mvp.FWIView;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020-01-13  13:25
 * 描    述
 * 修订历史：
 * ================================================
 */
public interface GankDataContract {


    interface View extends FWIView {
        void loginSuccess(GankDataBean bean);

        void loginFailure();
    }

    interface Presenter extends FWIPresenter<View> {
        void loadGankData(String page);
    }

    interface Model extends FWIModel {
        void loadGankData(String page, FWSimpleJsonCallBack<GankDataBean> callback);
    }


}

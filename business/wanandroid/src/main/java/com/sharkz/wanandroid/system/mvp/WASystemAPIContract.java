package com.sharkz.wanandroid.system.mvp;

import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWIModel;
import com.sharkz.framework.mvp.FWIPresenter;
import com.sharkz.framework.mvp.FWIView;
import com.sharkz.wanandroid.system.bean.WASystemAPIBean;
import com.sharkz.wanandroid.system.bean.WASystemListAPIBean;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/17  12:20
 * 描    述 首页 Fragment P 层
 * 修订历史：
 * ================================================
 */
public interface WASystemAPIContract {

    interface View extends FWIView {
        void loadSuccess(WASystemAPIBean bean);

        void loadFail();
    }

    interface Presenter extends FWIPresenter<View> {
        void loadSystem();
    }

    interface Model extends FWIModel {
        void loadSystem(FWSimpleJsonCallBack<WASystemAPIBean> callback);
    }


    // =============================================================================================


     interface View2 extends FWIView {
        void loadSuccess(WASystemListAPIBean bean);

        void loadFail();
    }

    interface Presenter2 extends FWIPresenter<View2> {
        void loadSystemList(int a,int b);
    }

    interface Model2 extends FWIModel {
        void loadSystemList(int page,int cid,FWSimpleJsonCallBack<WASystemListAPIBean> callback);
    }




}

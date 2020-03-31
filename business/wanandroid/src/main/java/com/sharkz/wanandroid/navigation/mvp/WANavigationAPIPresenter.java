package com.sharkz.wanandroid.navigation.mvp;

import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWBasePresenter;
import com.sharkz.okgo.sdk.model.Response;
import com.sharkz.wanandroid.navigation.bean.WANavigationBean;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/28  12:04
 * 描    述
 * 修订历史：
 * ================================================
 */
public class WANavigationAPIPresenter extends FWBasePresenter<WANavigationAPIContract.Model,WANavigationAPIContract.View> implements WANavigationAPIContract.Presenter {

    @Override
    protected WANavigationAPIContract.Model createModel() {
        return new WANavigationAPIModel(getView());
    }

    @Override
    public void loadNavigation() {
        getModel().loadNavigation(new FWSimpleJsonCallBack<WANavigationBean>(getView()) {
            @Override
            public void onSuccess(Response<WANavigationBean> response) {
               if (getView()!=null)getView().loadSuccess(response.body());
            }

            @Override
            public void onError(Response<WANavigationBean> response) {
                super.onError(response);
               if (getView()!=null)getView().loadFailure();
            }
        });
    }
}

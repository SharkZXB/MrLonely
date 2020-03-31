package com.sharkz.tabvideo.mvp;

import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWBasePresenter;
import com.sharkz.okgo.sdk.model.Response;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020-01-13  13:30
 * 描    述
 * 修订历史：
 * ================================================
 */
public class GankDataPresenter extends FWBasePresenter<GankDataContract.Model, GankDataContract.View> implements GankDataContract.Presenter {

    @Override
    protected GankDataContract.Model createModel() {
        return new GankDataModel(getView());
    }

    @Override
    public void loadGankData(String page) {
        getModel().loadGankData(page, new FWSimpleJsonCallBack<GankDataBean>(getView()) {
            @Override
            public void onSuccess(Response<GankDataBean> response) {
                getView().loginSuccess(response.body());
            }

            @Override
            public void onError(Response<GankDataBean> response) {
                super.onError(response);
                getView().loginFailure();
            }
        });
    }
}

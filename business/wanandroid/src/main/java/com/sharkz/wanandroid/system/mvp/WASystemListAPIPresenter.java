package com.sharkz.wanandroid.system.mvp;

import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWBasePresenter;
import com.sharkz.okgo.sdk.model.Response;
import com.sharkz.wanandroid.system.bean.WASystemAPIBean;
import com.sharkz.wanandroid.system.bean.WASystemListAPIBean;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/28  13:56
 * 描    述
 * 修订历史：
 * ================================================
 */
public class WASystemListAPIPresenter extends FWBasePresenter<WASystemAPIContract.Model2, WASystemAPIContract.View2> implements WASystemAPIContract.Presenter2 {


    @Override
    protected WASystemAPIContract.Model2 createModel() {
        return new WASystemListAPIModel(getView());
    }

    @Override
    public void loadSystemList(int page, int cid) {
        getModel().loadSystemList(page, cid, new FWSimpleJsonCallBack<WASystemListAPIBean>(getView()) {
            @Override
            public void onSuccess(Response<WASystemListAPIBean> response) {
                getView().loadSuccess(response.body());
            }

            @Override
            public void onError(Response<WASystemListAPIBean> response) {
                super.onError(response);
                getView().loadFail();
            }
        });
    }

}

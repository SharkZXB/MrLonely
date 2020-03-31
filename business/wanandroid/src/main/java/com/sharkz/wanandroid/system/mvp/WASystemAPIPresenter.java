package com.sharkz.wanandroid.system.mvp;

import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWBasePresenter;
import com.sharkz.okgo.sdk.model.Response;
import com.sharkz.wanandroid.system.bean.WASystemAPIBean;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/28  13:56
 * 描    述
 * 修订历史：
 * ================================================
 */
public class WASystemAPIPresenter extends FWBasePresenter<WASystemAPIContract.Model, WASystemAPIContract.View> implements WASystemAPIContract.Presenter {

    @Override
    protected WASystemAPIContract.Model createModel() {
        return new WASystemAPIModel(getView());
    }

    @Override
    public void loadSystem() {
        getModel().loadSystem(new FWSimpleJsonCallBack<WASystemAPIBean>(getView()) {
            @Override
            public void onSuccess(Response<WASystemAPIBean> response) {
                getView().loadSuccess(response.body());
            }
        });
    }
}

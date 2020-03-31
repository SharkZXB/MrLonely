package com.sharkz.wanandroid.square.mvp;

import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWBasePresenter;
import com.sharkz.okgo.sdk.model.Response;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/25  22:53
 * 描    述
 * 修订历史：
 * ================================================
 */
public class WASquareAPIPresenter extends FWBasePresenter<WASquareAPIContract.Model, WASquareAPIContract.View> implements WASquareAPIContract.Presenter {

    @Override
    protected WASquareAPIContract.Model createModel() {
        return new WASquareAPIModel(getView());
    }

    @Override
    public void loadSquare(int page) {
        getModel().loadSquare(page,new FWSimpleJsonCallBack<WASquareBean>(getView()) {
            @Override
            public void onSuccess(Response<WASquareBean> response) {
                getView().loadSuccess(response.body());
            }
        });
    }
}

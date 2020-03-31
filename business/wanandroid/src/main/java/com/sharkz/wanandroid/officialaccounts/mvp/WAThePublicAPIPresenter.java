package com.sharkz.wanandroid.officialaccounts.mvp;

import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWBasePresenter;
import com.sharkz.okgo.sdk.model.Response;
import com.sharkz.wanandroid.officialaccounts.bean.WAChaptersListBean;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/19  15:11
 * 描    述
 * 修订历史：
 * ================================================
 */
public class WAThePublicAPIPresenter extends FWBasePresenter<WAThePublicAPIContract.Model, WAThePublicAPIContract.View> implements WAThePublicAPIContract.Presenter {

    @Override
    protected WAThePublicAPIContract.Model createModel() {
        return new WAThePublicAPIModel(getView());
    }

    @Override
    public void loadChaptersList() {
        getModel().loadChaptersList(new FWSimpleJsonCallBack<WAChaptersListBean>(getView()) {
            @Override
            public void onSuccess(Response<WAChaptersListBean> response) {
                getView().loadChaptersListSuccess(response.body());
            }
        });
    }
}

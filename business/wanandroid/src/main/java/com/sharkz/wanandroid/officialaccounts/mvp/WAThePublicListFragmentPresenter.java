package com.sharkz.wanandroid.officialaccounts.mvp;

import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWBasePresenter;
import com.sharkz.okgo.sdk.model.Response;
import com.sharkz.wanandroid.officialaccounts.bean.WAThePublicListBean;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/19  16:14
 * 描    述
 * 修订历史：
 * ================================================
 */
public class WAThePublicListFragmentPresenter extends
        FWBasePresenter<WAThePublicAPIContract.Model2, WAThePublicAPIContract.View2>
        implements WAThePublicAPIContract.Presenter2 {

    @Override
    protected WAThePublicAPIContract.Model2 createModel() {
        return new WAThePublicListFragmentModel(getView());
    }

    @Override
    public void loadChaptersList(int id, int page) {
            getModel().loadChaptersList(id, page, new FWSimpleJsonCallBack<WAThePublicListBean>(getView()) {
                @Override
                public void onSuccess(Response<WAThePublicListBean> response) {
                    if (response!=null && response.body()!=null && getView()!=null){
                        getView().loadThePublicList(response.body());
                    }
                }

                @Override
                public void onError(Response<WAThePublicListBean> response) {
                    //super.onError(response);
                    getView().loadThePublicListFailure();
                }
            });
    }

}

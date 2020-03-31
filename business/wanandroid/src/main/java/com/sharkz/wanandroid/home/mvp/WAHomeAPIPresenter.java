package com.sharkz.wanandroid.home.mvp;

import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWBasePresenter;
import com.sharkz.okgo.sdk.model.Response;
import com.sharkz.wanandroid.home.bean.WAHomeArticleListBean;
import com.sharkz.wanandroid.home.bean.WAHomeBannerBean;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/17  12:28
 * 描    述
 * 修订历史：
 * ================================================
 */
public class WAHomeAPIPresenter extends FWBasePresenter<WAHomeAPIContract.Model, WAHomeAPIContract.View> implements WAHomeAPIContract.Presenter {

    @Override
    protected WAHomeAPIContract.Model createModel() {
        return new WAHomeAPIModel(getView());
    }

    @Override
    public void loadHomeBanner() {
        getModel().loadHomeBanner(new FWSimpleJsonCallBack<WAHomeBannerBean>(getView()) {
            @Override
            public void onSuccess(Response<WAHomeBannerBean> response) {
                getView().homeBannerSuccess(response.body());
            }
        });
    }

    @Override
    public void loadHomeArticleTop() {

    }

    @Override
    public void loadHomeArticle(int pageNum) {
        getModel().loadHomeArticle(pageNum, new FWSimpleJsonCallBack<WAHomeArticleListBean>(getView()) {
            @Override
            public void onSuccess(Response<WAHomeArticleListBean> response) {
                getView().homeArticleSuccess(response.body());
            }
        });
    }
}

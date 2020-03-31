package com.sharkz.wanandroid.home.mvp;

import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWBaseModel;
import com.sharkz.framework.mvp.FWIView;
import com.sharkz.okgo.sdk.OkGo;
import com.sharkz.wanandroid.home.bean.WAHomeArticleListBean;
import com.sharkz.wanandroid.home.bean.WAHomeBannerBean;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/17  12:27
 * 描    述
 * 修订历史：
 * ================================================
 */
public class WAHomeAPIModel extends FWBaseModel implements WAHomeAPIContract.Model {

    public WAHomeAPIModel(FWIView iView) {
        super(iView);
    }

    @Override
    public void loadHomeBanner(FWSimpleJsonCallBack<WAHomeBannerBean> callback) {
        OkGo.<WAHomeBannerBean>get(WAHomeAPI.Home_Banner)
                .tag(iView.get())
                .execute(callback);
    }

    @Override
    public void loadHomeArticleTop(FWSimpleJsonCallBack<String> callback) {

    }

    @Override
    public void loadHomeArticle(int page, FWSimpleJsonCallBack<WAHomeArticleListBean> callback) {
        OkGo.<WAHomeArticleListBean>get(String.format(WAHomeAPI.HOME_article,page))
                .tag(iView.get())
                .execute(callback);
    }
}

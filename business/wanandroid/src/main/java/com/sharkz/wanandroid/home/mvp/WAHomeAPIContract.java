package com.sharkz.wanandroid.home.mvp;

import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWIModel;
import com.sharkz.framework.mvp.FWIPresenter;
import com.sharkz.framework.mvp.FWIView;
import com.sharkz.wanandroid.home.bean.WAHomeArticleListBean;
import com.sharkz.wanandroid.home.bean.WAHomeBannerBean;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/17  12:20
 * 描    述 首页 Fragment P 层
 * 修订历史：
 * ================================================
 */
public interface WAHomeAPIContract {

    interface View extends FWIView {
        void homeBannerSuccess(WAHomeBannerBean WAHomeBannerBean);
        void homeArticleTopSuccess();
        void homeArticleSuccess(WAHomeArticleListBean WAHomeArticleListBean);

        void homeArticleFailure();
    }

    interface Presenter extends FWIPresenter<View> {
        void loadHomeBanner();           // 顶部Banner
        void loadHomeArticleTop();       // 置顶文章
        void loadHomeArticle(int page);  // 首页文章
    }

    interface Model extends FWIModel {
        void loadHomeBanner(FWSimpleJsonCallBack<WAHomeBannerBean> callback);
        void loadHomeArticleTop(FWSimpleJsonCallBack<String> callback);
        void loadHomeArticle(int pageNum, FWSimpleJsonCallBack<WAHomeArticleListBean> callback);
    }

}

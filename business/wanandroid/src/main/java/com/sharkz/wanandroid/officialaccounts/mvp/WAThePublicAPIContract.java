package com.sharkz.wanandroid.officialaccounts.mvp;

import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWIModel;
import com.sharkz.framework.mvp.FWIPresenter;
import com.sharkz.framework.mvp.FWIView;
import com.sharkz.wanandroid.officialaccounts.bean.WAChaptersListBean;
import com.sharkz.wanandroid.officialaccounts.bean.WAThePublicListBean;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/19  15:11
 * 描    述
 * 修订历史：
 * ================================================
 */
public interface WAThePublicAPIContract {

    /**
     * 主界面
     */
    interface View extends FWIView {
        void loadChaptersListSuccess(WAChaptersListBean WAChaptersListBean);
    }

    interface Presenter extends FWIPresenter<View> {
        void loadChaptersList();
    }

    interface Model extends FWIModel {
      void loadChaptersList(FWSimpleJsonCallBack<WAChaptersListBean> callBack);
    }

    /**
     * 下面是 列表Fragment
     */
    interface View2 extends FWIView{
        void loadThePublicList(WAThePublicListBean WAThePublicListBean);
        void loadThePublicListFailure();
    }

    interface Presenter2 extends FWIPresenter<View2> {
        void loadChaptersList(int id, int page);
    }

    interface Model2 extends FWIModel {
        void loadChaptersList(int id, int page, FWSimpleJsonCallBack<WAThePublicListBean> callBack);
    }

}

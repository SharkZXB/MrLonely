package com.sharkz.wanandroid.square.mvp;

import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWIModel;
import com.sharkz.framework.mvp.FWIPresenter;
import com.sharkz.framework.mvp.FWIView;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/17  12:20
 * 描    述 首页 Fragment P 层
 * 修订历史：
 * ================================================
 */
public interface WASquareAPIContract {

    interface View extends FWIView {
        void loadSuccess(WASquareBean bean);

        void loadFail();
    }

    interface Presenter extends FWIPresenter<View> {
        void loadSquare(int page);
    }

    interface Model extends FWIModel {
        void loadSquare(int page,FWSimpleJsonCallBack<WASquareBean> callback);
    }

}

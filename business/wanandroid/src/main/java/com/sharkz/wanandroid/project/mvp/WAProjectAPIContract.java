package com.sharkz.wanandroid.project.mvp;

import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWIModel;
import com.sharkz.framework.mvp.FWIPresenter;
import com.sharkz.framework.mvp.FWIView;
import com.sharkz.wanandroid.project.bean.WAProjectBean;
import com.sharkz.wanandroid.project.bean.WAProjectListBean;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/27  14:51
 * 描    述
 * 修订历史：
 * ================================================
 */
public interface WAProjectAPIContract {

    interface View extends FWIView {
        void loadSuccess(WAProjectBean bean);

        void loadFail();
    }

    interface Presenter extends FWIPresenter<View> {
        void loadProject();
    }

    interface Model extends FWIModel {
        void loadProject(FWSimpleJsonCallBack<WAProjectBean> callback);
    }

    // =============================================================================================

    interface View2 extends FWIView{
        void loadSuccess(WAProjectListBean bean);
        void loadFail();
    }

    interface Presenter2 extends FWIPresenter<View2>{
        void loadProjectList(int cid,int page);
    }

    interface Model2 extends FWIModel {
        void loadProjectList(int cid, int  page,FWSimpleJsonCallBack<WAProjectListBean> callback);
    }

}

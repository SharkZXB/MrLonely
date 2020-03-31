package com.sharkz.wanandroid.project.mvp;

import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWBasePresenter;
import com.sharkz.okgo.sdk.model.Response;
import com.sharkz.wanandroid.project.bean.WAProjectListBean;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/27  14:55
 * 描    述
 * 修订历史：
 * ================================================
 */
public class WAProjectListAPIPresenter extends FWBasePresenter<WAProjectAPIContract.Model2, WAProjectAPIContract.View2> implements WAProjectAPIContract.Presenter2 {

    @Override
    protected WAProjectAPIContract.Model2 createModel() {
        return new WAProjectListAPIModel(getView());
    }


    @Override
    public void loadProjectList(int cid, int page) {
        getModel().loadProjectList(cid, page, new FWSimpleJsonCallBack<WAProjectListBean>(getView()) {
            @Override
            public void onSuccess(Response<WAProjectListBean> response) {
                getView().loadSuccess(response.body());
            }
        });
    }
}

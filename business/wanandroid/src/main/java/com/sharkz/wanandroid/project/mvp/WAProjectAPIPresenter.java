package com.sharkz.wanandroid.project.mvp;

import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWBasePresenter;
import com.sharkz.okgo.sdk.model.Response;
import com.sharkz.wanandroid.project.bean.WAProjectBean;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/27  14:55
 * 描    述
 * 修订历史：
 * ================================================
 */
public class WAProjectAPIPresenter extends FWBasePresenter<WAProjectAPIContract.Model, WAProjectAPIContract.View> implements WAProjectAPIContract.Presenter {

    @Override
    protected WAProjectAPIContract.Model createModel() {
        return new WAProjectAPIModel(getView());
    }

    @Override
    public void loadProject() {
        getModel().loadProject(new FWSimpleJsonCallBack<WAProjectBean>(getView()) {
            @Override
            public void onSuccess(Response<WAProjectBean> response) {
                getView().loadSuccess(response.body());
            }
        });
    }

}

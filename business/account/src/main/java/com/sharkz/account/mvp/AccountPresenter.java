package com.sharkz.account.mvp;

import android.util.Log;

import com.sharkz.account.bean.LoginBean;
import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWBasePresenter;
import com.sharkz.okgo.sdk.model.Response;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/21  19:13
 * 描    述
 * 修订历史：
 * ================================================
 */
public class AccountPresenter extends FWBasePresenter<AccountAPIContract.Model, AccountAPIContract.View> implements AccountAPIContract.Presenter {

    @Override
    protected AccountAPIContract.Model createModel() {
        return new AccountModel(getView());
    }

    @Override
    public void login(String username, String password) {
        getModel().login(username, password, new FWSimpleJsonCallBack<LoginBean>(getView()) {
            @Override
            public void onSuccess(Response<LoginBean> response) {
                LoginBean loginBean = response.body();
                if (loginBean.getErrorCode() < 0) {
                    onError(response);
                } else {
                    getView().loginSuccess(response.body());
                }
            }

            @Override
            public void onError(Response<LoginBean> response) {
                super.onError(response);
                LoginBean loginBean = response.body();
                getView().loginFailed(loginBean.getErrorMsg());
            }
        });
    }

    @Override
    public void register(String username, String password, String repassword) {
        getModel().register(username, password, repassword, new FWSimpleJsonCallBack<LoginBean>(getView()) {
            @Override
            public void onSuccess(Response<LoginBean> response) {
                LoginBean loginBean = response.body();
                if (loginBean.getErrorCode() < 0) {
                    onError(response);
                } else {
                    getView().registerSuccess(response.body());
                }
            }

            @Override
            public void onError(Response<LoginBean> response) {
                super.onError(response);
                LoginBean bean = response.body();
                getView().registerFailed(bean.getErrorMsg());
            }
        });
    }

}

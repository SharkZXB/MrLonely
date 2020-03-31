package com.sharkz.account.mvp;

import com.sharkz.account.bean.LoginBean;
import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWBaseModel;
import com.sharkz.framework.mvp.FWIView;
import com.sharkz.okgo.sdk.OkGo;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/21  19:13
 * 描    述
 * 修订历史：
 * ================================================
 */
public class AccountModel extends FWBaseModel implements AccountAPIContract.Model {

    public AccountModel(FWIView iView) {
        super(iView);
    }

    @Override
    public void login(String username, String password, FWSimpleJsonCallBack<LoginBean> callback) {
        OkGo.<LoginBean>post(AccountAPI.login)
                .tag(this)
                .params("username", username)
                .params("password", password)
                .execute(callback);
    }

    @Override
    public void register(String username, String password, String repassword, FWSimpleJsonCallBack<LoginBean> callback) {
        OkGo.<LoginBean>post(AccountAPI.register)
                .tag(this)
                .params("username", username)
                .params("password", password)
                .params("repassword", repassword)
                .execute(callback);

    }
}

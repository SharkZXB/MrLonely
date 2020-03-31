package com.sharkz.account.mvp;

import com.sharkz.account.bean.LoginBean;
import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWIModel;
import com.sharkz.framework.mvp.FWIPresenter;
import com.sharkz.framework.mvp.FWIView;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/21  19:08
 * 描    述
 * 修订历史：
 * ================================================
 */
public interface AccountAPIContract {

    interface View extends FWIView {
        void loginSuccess(LoginBean loginBean);
        void loginFailed(String msg);

        void registerSuccess(LoginBean loginBean);
        void registerFailed(String msg);

    }

    interface Presenter extends FWIPresenter<View> {
        void login(String username,String password );
        void register(String username,String password, String repassword );
    }

    interface Model extends FWIModel {
        void login(String username,String password,FWSimpleJsonCallBack<LoginBean> callback);
        void register(String username,String password, String repassword ,FWSimpleJsonCallBack<LoginBean> callback);
    }

}

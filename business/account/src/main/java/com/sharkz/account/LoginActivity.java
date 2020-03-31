package com.sharkz.account;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.Group;

import com.gyf.immersionbar.ImmersionBar;
import com.sharkz.account.bean.LoginBean;
import com.sharkz.account.mvp.AccountAPIContract;
import com.sharkz.account.mvp.AccountPresenter;
import com.sharkz.framework.base.activity.FWBaseMvpActivity;

import butterknife.BindView;
import butterknife.OnClick;

import static com.sharkz.account.LoginTool.callBack;


/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/21  19:07
 * 描    述 登陆界面
 * 修订历史：
 * ================================================
 */
public class LoginActivity extends FWBaseMvpActivity<AccountPresenter> implements AccountAPIContract.View {

    @BindView(R2.id.ivBg)
    ImageView ivBg;
    @BindView(R2.id.etName)
    EditText etName;
    @BindView(R2.id.etPWD)
    EditText etPWD;
    @BindView(R2.id.etRePWD)
    EditText etRePWD;
    @BindView(R2.id.tvSwitch)
    TextView tvSwitch;
    @BindView(R2.id.tvLogin)
    TextView tvLogin;
    @BindView(R2.id.group)
    Group group;


    private boolean isLogin = true;  // 当前是否是登录模式

    // =============================================================================================


    @Override
    public void setIsNavigationBarOverlap() {
       // super.setIsNavigationBarOverlap();
        mSwipeBackHelper.setIsNavigationBarOverlap(true);
    }

    @Override
    public void setImmersionBar() {
        ImmersionBar.with(this)
                .transparentBar()
                .init();
    }

    @Override
    protected AccountPresenter createPresenter() {
        return new AccountPresenter();
    }

    @Override
    public int setRealLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void loadData() {

    }


    // =============================================================================================


    @Override
    public void loginSuccess(LoginBean loginBean) {
        if (callBack != null) {
            callBack.loginSuccess();
            finish();
        }
    }

    @Override
    public void loginFailed(String msg) {
        Toast.makeText(this, "登录失败" + msg, Toast.LENGTH_SHORT).show();
        if (callBack != null) {
            callBack.loginFailed();
        }
    }

    @Override
    public void registerSuccess(LoginBean loginBean) {
        if (callBack != null) {
            callBack.loginSuccess();
            finish();
        }
    }

    @Override
    public void registerFailed(String msg) {
        Toast.makeText(this, "注册失败      " + msg, Toast.LENGTH_SHORT).show();
        if (callBack != null) {
            // callBack.loginFailed();
        }
    }


    // =============================================================================================

    @OnClick({R2.id.tvLogin})
    public void onClickBtn() {
        if (TextUtils.isEmpty(etName.getText().toString())) {
            Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(etPWD.getText().toString())) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return;
        }
        if (isLogin) {
            mPresenter.login(etName.getText().toString(), etPWD.getText().toString());
        } else {
            if (TextUtils.isEmpty(etRePWD.getText().toString())) {
                Toast.makeText(this, "请再次输入密码", Toast.LENGTH_SHORT).show();
                return;
            }
            mPresenter.register(etName.getText().toString().trim(), etPWD.getText().toString().trim(), etRePWD.getText().toString().trim());
        }

    }

    @OnClick({R2.id.tvSwitch})
    public void onClickBtnSwitch() {
        if (TextUtils.equals(tvSwitch.getText(), "登录")) {
            group.setVisibility(View.GONE);
            tvSwitch.setText("注册");
            tvLogin.setText("登录");
            isLogin = true;
        } else {
            group.setVisibility(View.VISIBLE);
            tvSwitch.setText("登录");
            tvLogin.setText("注册");
            isLogin = false;
        }
    }

}

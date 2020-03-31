package com.sharkz.tabmine;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sharkz.account.AccountCallBack;
import com.sharkz.account.LoginTool;
import com.sharkz.framework.base.fragment.FWBaseMvpFragment;
import com.sharkz.framework.mvp.FWIPresenter;
import com.sharkz.notification.NotificationTool;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020-01-11  17:27
 * 描    述
 * 修订历史：
 * ================================================
 */
public class FragmentMine extends FWBaseMvpFragment {

    private TextView tvNotificationEnabled;

    @Override
    protected FWIPresenter createPresenter() {
        return null;
    }

    @Override
    protected void onCreateAfterView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_mine_layout;
    }

    @Override
    protected void initData() {
        Log.i(TAG, "initData: --> FragmentMine");
    }

    @Override
    protected void initView(View view) {
         tvNotificationEnabled = view.findViewById(R.id.tvNotificationEnabled);
    }

    @Override
    protected void setListener() {
        tvNotificationEnabled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // NotificationTool.setNotificationEnabled(getContext());
//                Intent intent = new Intent();
//                intent.setClassName(getContext(),"com.sharkz.account.LoginActivity");
//                startActivity(intent);

                LoginTool.login(getContext(), new AccountCallBack() {
                    @Override
                    public void loginSuccess() {
                        Toast.makeText(getContext(), "登录成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void loginFailed() {
                        Toast.makeText(getContext(), "登录失败", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

    @Override
    protected void loadData() {
//        Logger.d("debug");
//        Logger.e("error");
//        Logger.w("warning");
//        Logger.v("verbose");
//        Logger.i("information");
//        Logger.wtf("What a Terrible Failure");
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!NotificationTool.isNotificationEnabled(getContext())) {
            tvNotificationEnabled.setText("未开启通知");
        } else {
            //当前app允许消息通知
            tvNotificationEnabled.setText("已开启通知");
        }
    }

}

package com.sharkz.wanandroid.home.agentmodel;

import android.text.TextUtils;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sharkz.wanandroid.R;
import com.sharkz.wanandroid.WanAndroidARouterConstant;

import java.util.List;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/25  22:11
 * 描    述
 * 修订历史：
 * ================================================
 */
public class WAModulesNavigationAgentModelAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public WAModulesNavigationAgentModelAdapter(@Nullable List<String> data) {
        super(R.layout.wa_item_agent_1, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {
        helper.setText(R.id.tvName, item);
        helper.getView(R.id.rootLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.equals(item, "广场")) {
                    ARouter.getInstance().build(WanAndroidARouterConstant.A_ROUTER_URL_WA_SQUARE_ACTIVITY).navigation();
                }

                if (TextUtils.equals(item, "公众号")) {
                    ARouter.getInstance().build(WanAndroidARouterConstant.A_ROUTER_URL_WA_ACTIVITY_OFFICIAL_ACCOUNTS).navigation();
                }

                if (TextUtils.equals(item, "体系")) {
                    ARouter.getInstance().build(WanAndroidARouterConstant.A_ROUTER_URL_WA_ACTIVITY_SYSTEM).navigation();
                }

                if (TextUtils.equals(item, "项目")) {
                    ARouter.getInstance().build(WanAndroidARouterConstant.A_ROUTER_URL_WA_ACTIVITY_PROJECT).navigation();
                }

                if (TextUtils.equals(item, "导航")) {
                    ARouter.getInstance().build(WanAndroidARouterConstant.A_ROUTER_URL_WA_ACTIVITY_NAVIGATION).navigation();
                }

            }
        });
    }
}

package com.sharkz.wanandroid.officialaccounts.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sharkz.wanandroid.R;
import com.sharkz.wanandroid.officialaccounts.bean.WAThePublicListBean;
import com.sharkz.webview.WebViewService;

import java.util.List;


/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/19  16:28
 * 描    述
 * 修订历史：
 * ================================================
 */
public class WAThePublicListFragmentAdapter extends BaseQuickAdapter<WAThePublicListBean.DataBean.DatasBean, BaseViewHolder> {

    public WAThePublicListFragmentAdapter(@Nullable List<WAThePublicListBean.DataBean.DatasBean> data) {
        super(R.layout.item_the_public_layout, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, final WAThePublicListBean.DataBean.DatasBean item) {
        helper.setText(R.id.tvAuthor, item.getAuthor());
        helper.setText(R.id.tvNiceShareDate, item.getNiceShareDate());
        helper.setText(R.id.tvTitle, item.getTitle());
        helper.getView(R.id.rootLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebViewService webViewService = ARouter.getInstance().navigation(WebViewService.class);
                if (webViewService != null) {
                    webViewService.jump2WebViewActivity(item.getLink());
                }
            }
        });

    }
}

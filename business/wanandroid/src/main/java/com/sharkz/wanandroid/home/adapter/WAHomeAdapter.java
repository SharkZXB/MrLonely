package com.sharkz.wanandroid.home.adapter;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sharkz.wanandroid.R;
import com.sharkz.wanandroid.home.bean.WAHomeArticleListBean;
import com.sharkz.webview.WebViewService;

import java.util.List;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/17  12:58
 * 描    述
 * 修订历史：
 * ================================================
 */
public class WAHomeAdapter extends BaseQuickAdapter<WAHomeArticleListBean.DataBean.DatasBean, BaseViewHolder> {

    public WAHomeAdapter(@Nullable List<WAHomeArticleListBean.DataBean.DatasBean> data) {
        super(R.layout.tabhome_item_home_layout, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, WAHomeArticleListBean.DataBean.DatasBean item) {
        helper.setText(R.id.tvAuthor, item.getAuthor());
        helper.setText(R.id.tvNiceShareDate, item.getNiceShareDate());
        helper.setText(R.id.tvTitle, item.getTitle());
        helper.setText(R.id.tvSuperChapterName, item.getSuperChapterName() + "·" + item.getChapterName());
        helper.getView(R.id.ivCollect).setOnClickListener(v -> {
            Toast.makeText(mContext, "收藏", Toast.LENGTH_SHORT).show();
        });
        helper.getView(R.id.cardView).setOnClickListener(v -> {
            WebViewService webViewService = ARouter.getInstance().navigation(WebViewService.class);
            if (webViewService != null) {
                webViewService.jump2WebViewActivity(item.getLink());
            }
        });
    }
}

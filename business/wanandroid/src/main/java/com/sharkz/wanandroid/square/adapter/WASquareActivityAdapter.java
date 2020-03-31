package com.sharkz.wanandroid.square.adapter;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sharkz.wanandroid.R;
import com.sharkz.wanandroid.square.mvp.WASquareBean;
import com.sharkz.webview.WebViewService;

import java.util.List;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/25  22:34
 * 描    述 广场列表适配器
 * 修订历史：
 * ================================================
 */
public class WASquareActivityAdapter extends BaseQuickAdapter<WASquareBean.DataBean.DatasBean, BaseViewHolder> {

    public WASquareActivityAdapter(@Nullable List<WASquareBean.DataBean.DatasBean> data) {
        super(R.layout.wa_square_item_1,data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, WASquareBean.DataBean.DatasBean item) {
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

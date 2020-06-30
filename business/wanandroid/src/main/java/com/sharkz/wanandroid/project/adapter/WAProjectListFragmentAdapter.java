package com.sharkz.wanandroid.project.adapter;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sharkz.glide.GlideImage;
import com.sharkz.wanandroid.R;
import com.sharkz.wanandroid.project.bean.WAProjectListBean;
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
public class WAProjectListFragmentAdapter extends BaseQuickAdapter<WAProjectListBean.DataBean.DatasBean, BaseViewHolder> {

    public WAProjectListFragmentAdapter(@Nullable List<WAProjectListBean.DataBean.DatasBean> data) {
        super(R.layout.wa_item_project_list_fragment_adapter, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, final WAProjectListBean.DataBean.DatasBean item) {
        helper.setText(R.id.tvAuthor, item.getAuthor());
        helper.setText(R.id.tvNiceShareDate, item.getNiceShareDate());
        helper.setText(R.id.tvTitle, item.getTitle());
        helper.setText(R.id.tvDesc, item.getDesc());
        helper.setText(R.id.tvSuperChapterName, item.getSuperChapterName() + "·" + item.getChapterName());

        // 加载图片
        ImageView ivImg = helper.getView(R.id.ivImg);
        GlideImage.getInstance().displayImage(mContext, item.getEnvelopePic(), ivImg);

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

package com.sharkz.wanandroid.navigation.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.flexbox.FlexboxLayout;
import com.hjq.toast.ToastUtils;
import com.sharkz.wanandroid.R;
import com.sharkz.wanandroid.navigation.bean.WANavigationBean;
import com.sharkz.webview.WebViewService;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/28  12:30
 * 描    述
 * 修订历史：
 * ================================================
 */
public class WANavigationAdapter extends BaseQuickAdapter<WANavigationBean.DataBean, BaseViewHolder> {

    private LayoutInflater mInflater = null;
    private Queue<TextView> mFlexItemTextViewCaches = new LinkedList<>();

    public WANavigationAdapter(@Nullable List<WANavigationBean.DataBean> data) {
        super(R.layout.wa_item_navigation_activity_adapter, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, WANavigationBean.DataBean item) {

        helper.setText(R.id.tv_name,item.getName());

        FlexboxLayout fbl = helper.getView(R.id.flexboxLayout);
        for (int i = 0; i < item.getArticles().size(); i++) {
            final WANavigationBean.DataBean.ArticlesBean childItem = item.getArticles().get(i);

            TextView child = createOrGetCacheFlexItemTextView(fbl);
            child.setText(childItem.getTitle());
            int finalI = i;
            child.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    WebViewService webViewService = ARouter.getInstance().navigation(WebViewService.class);
                    if (webViewService != null) {
                        webViewService.jump2WebViewActivity(childItem.getLink());
                    }
                }
            });
            fbl.addView(child);
        }

    }


    private TextView createOrGetCacheFlexItemTextView(FlexboxLayout fbl) {
        TextView tv = mFlexItemTextViewCaches.poll();
        if (tv != null) {
            return tv;
        }
        return createFlexItemTextView(fbl);
    }

    private TextView createFlexItemTextView(FlexboxLayout fbl) {
        if (mInflater == null) {
            mInflater = LayoutInflater.from(fbl.getContext());
        }
        return (TextView) mInflater.inflate(R.layout.wa_item_navigation_activity_adapter_item_child, fbl, false);
    }
}

package com.sharkz.wanandroid.system.adapter;

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
import com.sharkz.wanandroid.WanAndroidARouterConstant;
import com.sharkz.wanandroid.system.bean.WASystemAPIBean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/28  14:02
 * 描    述
 * 修订历史：
 * ================================================
 */
public class WASystemAdapter extends BaseQuickAdapter<WASystemAPIBean.DataBean, BaseViewHolder> {


    private LayoutInflater mInflater = null;
    private Queue<TextView> mFlexItemTextViewCaches = new LinkedList<>();


    public WASystemAdapter(@Nullable List<WASystemAPIBean.DataBean> data) {
        super(R.layout.wa_item_system_activity_adapter, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, WASystemAPIBean.DataBean item) {

        helper.setText(R.id.tv_name, item.getName());

        FlexboxLayout fbl = helper.getView(R.id.flexboxLayout);
        fbl.removeAllViews();

        for (int i = 0; i < item.getChildren().size(); i++) {

            final WASystemAPIBean.DataBean.ChildrenBean childItem = item.getChildren().get(i);
            TextView child = createOrGetCacheFlexItemTextView(fbl);
            child.setText(childItem.getName());
            fbl.addView(child);

            int finalI = i;
            child.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ARouter.getInstance()
                            .build(WanAndroidARouterConstant.A_ROUTER_URL_WA_ACTIVITY_SYSTEM_LIST)
                            .withSerializable("Item",item)
                            .withInt("index", finalI)
                            .navigation();
                }
            });
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

package com.sharkz.tabvideo.adapter;

import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sharkz.tabvideo.R;
import com.sharkz.tabvideo.mvp.GankDataBean;

import java.util.List;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020-01-14  09:09
 * 描    述 FragmentVideo 列表适配器
 * 修订历史：
 * ================================================
 */
public class FragmentVideoListAdapter extends BaseQuickAdapter<GankDataBean.ResultsBean, BaseViewHolder> {

    public FragmentVideoListAdapter(@Nullable List<GankDataBean.ResultsBean> data) {
        super(R.layout.item_fragment_video_adapter_layout, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, GankDataBean.ResultsBean item) {

        /**
         * _id : 5e03fcc79d212207e200f0a4
         * createdAt : 2019-12-26T08:20:23.213Z
         * desc : 自定义文本控件，支持富文本，包含两种状态：编辑状态和预览状态。编辑状态中，可以对插入本地或者网络图片，可以同时插入多张有序图片和删除图片，支持图文混排，并且可以对文字内容简单操作加粗字体，设置字体下划线，支持设置文字超链接(超链接支持跳转)，支持字数和图片数量统计，功能完善中……
         * images : ["http://img.gank.io/47e11fc4-d522-44a1-ba21-cd6cba4e22d8","http://img.gank.io/fa4b83e8-03f6-4d04-8a3e-8db357cc9238","http://img.gank.io/d8d62f1c-ebc0-4362-a23d-3adbdaf56d79","http://img.gank.io/effcdf25-1a26-48dc-bee7-66374b0af1d5","http://img.gank.io/9ac91b47-5778-4ce3-b534-34b6cd0f975d"]
         * publishedAt : 2019-12-26T00:21:21.559Z
         * source : web
         * type : Android
         * url : https://github.com/yangchong211/YCCustomText
         * used : true
         * who : 潇湘剑雨
         */

        String str = "id=" + item.get_id() + "\n"
                + "createdAt=" + item.getCreatedAt() + "\n"
                // + "desc=" + item.getDesc() + "\n"
                // + "images=" + item.getImages().get(0) + "\n"
                + "publishedAt=" + item.getPublishedAt() + "\n"
                + "source=" + item.getSource() + "\n"
                + "type=" + item.getType() + "\n"
                + "url=" + item.getUrl() + "\n"
                + "used=" + item.isUsed() + "\n"
                + "who=" + item.getWho() + "\n";
        helper.setText(R.id.text, str);


        helper.getView(R.id.cardView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "去播放详情", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

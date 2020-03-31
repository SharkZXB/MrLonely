package com.sharkz.wanandroid.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.sharkz.wanandroid.home.bean.WAHomeBannerBean;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;


/**
 * 自定义布局，图片
 */
public class WAHomeBannerAdapter extends BannerAdapter<WAHomeBannerBean.DataBean, WAHomeBannerAdapter.ImageHolder> {

    private Context context;

    public WAHomeBannerAdapter(List<WAHomeBannerBean.DataBean> mDatas, Context context) {
        // 设置数据，也可以调用banner提供的方法,或者自己在adapter中实现
        super(mDatas);
        this.context=context;
    }

    /**
     * 更新数据
     *
     * @param data
     */
    public void updateData(List<WAHomeBannerBean.DataBean> data){
        //这里的代码自己发挥，比如如下的写法等等
        mDatas.clear();
        mDatas.addAll(data);
        notifyDataSetChanged();
    }


    /**
     * 创建ViewHolder，可以用viewType这个字段来区分不同的ViewHolder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ImageHolder onCreateHolder(ViewGroup parent, int viewType) {
        ImageView imageView = new ImageView(parent.getContext());
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new ImageHolder(imageView);
    }

    @Override
    public void onBindView(ImageHolder holder, WAHomeBannerBean.DataBean data, int position, int size) {
        //holder.imageView.setImageResource(data.getImagePath());

        if (data==null || context==null)return;
       // GlideImage.getInstance().displayImage(context,data.getImagePath(),holder.imageView);
        Glide.with(context)
                .load(data.getImagePath())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(holder.imageView);
    }


    class ImageHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        ImageHolder(@NonNull View view) {
            super(view);
            this.imageView = (ImageView) view;
        }
    }

}

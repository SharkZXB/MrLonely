package com.just.agentweb.guide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/30  14:08
 * 描    述 ViewPager 适配器
 * 修订历史：
 * ================================================
 */
public class GuideActivityAdapter extends PagerAdapter {

    private List<View> mViewList;
    private Context context;

    public GuideActivityAdapter(Context context, List<View> mViewList) {
        this.context = context;
        if (mViewList == null) {
            this.mViewList = new ArrayList<>();
        } else {
            this.mViewList = mViewList;
        }
    }

    @Override
    public int getCount() {
        // return mViewList.size();
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {//必须实现，实例化
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.guide_activity_guide_item_adapter, null);
        container.addView(view);
        //container.addView(mViewList.get(position));
        //return mViewList.get(position);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {//必须实现，销毁
        // container.removeView(mViewList.get(position));
        container.removeView((View) object);
    }

}

package com.sharkz.wanandroid.home.agentmodel;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.launcher.ARouter;
import com.sharkz.wanandroid.R;
import com.sharkz.wanandroid.home.adapter.WAHomeBannerAdapter;
import com.sharkz.wanandroid.home.bean.WAHomeBannerBean;
import com.sharkz.webview.WebViewService;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.util.BannerUtils;

import java.lang.ref.WeakReference;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/25  10:38
 * 描    述 首页Banner 代理类  处理首页Banner的
 * 修订历史：
 * ================================================
 */
public class WAHomeBannerAgentModel {


    private WeakReference<Context> context;
    private Banner bannerView;

    public WAHomeBannerAgentModel(Context context) {
        this.context = new WeakReference<>(context);
    }

    public Banner getBannerView() {
        bannerView = (Banner) LayoutInflater.from(context.get()).inflate(R.layout.tabhome_banner, null);
        // bannerView.setBannerHeight(200);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, (int) BannerUtils.dp2px(200));
        params.leftMargin=20;
        params.rightMargin=20;
        params.topMargin=20;
       // params.bottomMargin=20;
        bannerView.setLayoutParams(params);

        WAHomeBannerAdapter bannerAdapter = new WAHomeBannerAdapter(null, context.get());
        bannerView.setAdapter(bannerAdapter);
        bannerView.setIndicator(new CircleIndicator(context.get()));
        bannerView.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(Object data, int position) {
                if (data instanceof WAHomeBannerBean.DataBean) {
                    WebViewService webViewService = ARouter.getInstance().navigation(WebViewService.class);
                    if (webViewService != null) {
                        webViewService.jump2WebViewActivity(((WAHomeBannerBean.DataBean) data).getUrl());
                    }
                }
            }

            @Override
            public void onBannerChanged(int position) {

            }
        });
        return bannerView;
    }

}

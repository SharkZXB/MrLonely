package com.sharkz.tabvideo.mvp;

import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWBaseModel;
import com.sharkz.framework.mvp.FWIView;
import com.sharkz.okgo.sdk.OkGo;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020-01-13  13:28
 * 描    述
 * 修订历史：
 * ================================================
 */
public class GankDataModel extends FWBaseModel implements GankDataContract.Model {


    public GankDataModel(FWIView iView) {
        super(iView);
    }

    @Override
    public void loadGankData(String page, FWSimpleJsonCallBack<GankDataBean> callback) {

        String url = Api.rest_video_gank + "10/" + page;

        OkGo.<GankDataBean>get(url)
                .tag(iView.get())//
                .headers("header1", "headerValue1")//
                .params("param1", "paramValue1")//
                .execute(callback);
    }
}

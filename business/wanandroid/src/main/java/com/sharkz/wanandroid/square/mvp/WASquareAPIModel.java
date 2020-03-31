package com.sharkz.wanandroid.square.mvp;

import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWBaseModel;
import com.sharkz.framework.mvp.FWIView;
import com.sharkz.okgo.sdk.OkGo;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/25  22:52
 * 描    述
 * 修订历史：
 * ================================================
 */
public class WASquareAPIModel extends FWBaseModel implements WASquareAPIContract.Model {

    public WASquareAPIModel(FWIView iView) {
        super(iView);
    }

    @Override
    public void loadSquare(int page, FWSimpleJsonCallBack<WASquareBean> callback) {
        OkGo.<WASquareBean>get(String.format(WASquareAPI.user_article, page))
                .tag(iView.get())
                .execute(callback);
    }
}

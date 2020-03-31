package com.sharkz.wanandroid.system.mvp;

import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWBaseModel;
import com.sharkz.framework.mvp.FWIView;
import com.sharkz.okgo.sdk.OkGo;
import com.sharkz.wanandroid.system.bean.WASystemAPIBean;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/28  13:55
 * 描    述
 * 修订历史：
 * ================================================
 */
public class WASystemAPIModel extends FWBaseModel implements WASystemAPIContract.Model {

    public WASystemAPIModel(FWIView iView) {
        super(iView);
    }

    @Override
    public void loadSystem(FWSimpleJsonCallBack<WASystemAPIBean> callback) {
        OkGo.<WASystemAPIBean>get(String.format(WASystemAPI.tree))
                .tag(iView.get())
                .execute(callback);
    }
}

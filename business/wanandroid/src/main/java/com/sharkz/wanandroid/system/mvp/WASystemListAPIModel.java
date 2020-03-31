package com.sharkz.wanandroid.system.mvp;

import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWBaseModel;
import com.sharkz.framework.mvp.FWIView;
import com.sharkz.okgo.sdk.OkGo;
import com.sharkz.wanandroid.system.bean.WASystemAPIBean;
import com.sharkz.wanandroid.system.bean.WASystemListAPIBean;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/28  13:55
 * 描    述
 * 修订历史：
 * ================================================
 */
public class WASystemListAPIModel extends FWBaseModel implements WASystemAPIContract.Model2 {

    public WASystemListAPIModel(FWIView iView) {
        super(iView);
    }

    @Override
    public void loadSystemList(int page, int cid, FWSimpleJsonCallBack<WASystemListAPIBean> callback) {
        OkGo.<WASystemListAPIBean>get(String.format(WASystemAPI.tree_list,page,cid))
                .tag(iView.get())
                .execute(callback);
    }

}

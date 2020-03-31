package com.sharkz.wanandroid.project.mvp;

import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWBaseModel;
import com.sharkz.framework.mvp.FWIView;
import com.sharkz.okgo.sdk.OkGo;
import com.sharkz.wanandroid.project.bean.WAProjectBean;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/27  14:54
 * 描    述
 * 修订历史：
 * ================================================
 */
public class WAProjectAPIModel extends FWBaseModel implements WAProjectAPIContract.Model {

    public WAProjectAPIModel(FWIView iView) {
        super(iView);
    }

    @Override
    public void loadProject(FWSimpleJsonCallBack<WAProjectBean> callback) {
        OkGo.<WAProjectBean>get(String.format(WAProjectAPI.project))
                .tag(iView.get())
                .execute(callback);
    }
}

package com.sharkz.wanandroid.officialaccounts.mvp;

import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWBaseModel;
import com.sharkz.framework.mvp.FWIView;
import com.sharkz.okgo.sdk.OkGo;
import com.sharkz.wanandroid.officialaccounts.bean.WAChaptersListBean;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/19  15:19
 * 描    述
 * 修订历史：
 * ================================================
 */
public class WAThePublicAPIModel extends FWBaseModel implements WAThePublicAPIContract.Model {

    public WAThePublicAPIModel(FWIView iView) {
        super(iView);
    }

    @Override
    public void loadChaptersList(FWSimpleJsonCallBack<WAChaptersListBean> callBack) {
        OkGo.<WAChaptersListBean>get(String.format(WAThePublicAPI.ChaptersList))
                .tag(iView.get())
                .execute(callBack);
    }
}

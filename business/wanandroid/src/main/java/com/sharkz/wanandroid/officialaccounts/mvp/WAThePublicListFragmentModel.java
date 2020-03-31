package com.sharkz.wanandroid.officialaccounts.mvp;

import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWBaseModel;
import com.sharkz.framework.mvp.FWIView;
import com.sharkz.okgo.sdk.OkGo;
import com.sharkz.wanandroid.officialaccounts.bean.WAThePublicListBean;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/19  16:17
 * 描    述
 * 修订历史：
 * ================================================
 */
public class WAThePublicListFragmentModel extends FWBaseModel implements WAThePublicAPIContract.Model2 {

    public WAThePublicListFragmentModel(FWIView iView) {
        super(iView);
    }

    @Override
    public void loadChaptersList(int id , int page, FWSimpleJsonCallBack<WAThePublicListBean> callBack) {
        OkGo.<WAThePublicListBean>get(String.format(WAThePublicAPI.ThePublicList,id,page))
                .tag(iView.get())
                .execute(callBack);
    }
}

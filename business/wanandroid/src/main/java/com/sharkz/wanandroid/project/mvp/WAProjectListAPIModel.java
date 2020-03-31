package com.sharkz.wanandroid.project.mvp;

import com.sharkz.framework.callback.FWSimpleJsonCallBack;
import com.sharkz.framework.mvp.FWBaseModel;
import com.sharkz.framework.mvp.FWIView;
import com.sharkz.okgo.sdk.OkGo;
import com.sharkz.wanandroid.project.bean.WAProjectListBean;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/27  14:54
 * 描    述
 * 修订历史：
 * ================================================
 */
public class WAProjectListAPIModel extends FWBaseModel implements WAProjectAPIContract.Model2 {

    public WAProjectListAPIModel(FWIView iView) {
        super(iView);
    }

    @Override
    public void loadProjectList(int cid, int page, FWSimpleJsonCallBack<WAProjectListBean> callback) {
        OkGo.<WAProjectListBean>get(String.format(WAProjectAPI.projectList, page, cid))
                .tag(iView.get())
                .execute(callback);
    }
}

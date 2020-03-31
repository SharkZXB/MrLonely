package com.sharkz.wanandroid.officialaccounts.mvp;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/19  15:04
 * 描    述
 * 修订历史：
 * ================================================
 */
public class WAThePublicAPI {


    /**
     * 获取公众号列表
     */
    public static final String ChaptersList="https://wanandroid.com/wxarticle/chapters/json";

    /**
     * 查看某个公众号历史数据
     * https://wanandroid.com/wxarticle/list/408/1/json
     * 方法：GET
     * 参数：
     * 	公众号 ID：拼接在 url 中，eg:405
     * 	公众号页码：拼接在url 中，eg:1
     */
    public static final String ThePublicList="https://wanandroid.com/wxarticle/list/%d/%d/json";


}

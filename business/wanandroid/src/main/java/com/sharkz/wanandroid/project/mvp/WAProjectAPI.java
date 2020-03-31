package com.sharkz.wanandroid.project.mvp;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/27  14:47
 * 描    述 玩Android 项目
 * 修订历史：
 * ================================================
 */
public class WAProjectAPI {

    /**
     * 项目分类
     * https://www.wanandroid.com/project/tree/json
     *
     * 方法： GET
     * 参数： 无
     */
    public static final String project ="https://www.wanandroid.com/project/tree/json";

    /**
     * 项目列表数据
     * https://www.wanandroid.com/project/list/1/json?cid=294
     *
     * 方法：GET
     * 参数：
     * 	cid 分类的id，上面项目分类接口
     * 	页码：拼接在链接中，从1开始。
     */
    public static final String projectList="https://www.wanandroid.com/project/list/%d/json?cid=%d";

}

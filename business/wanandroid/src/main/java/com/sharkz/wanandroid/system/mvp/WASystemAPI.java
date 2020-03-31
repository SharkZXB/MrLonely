package com.sharkz.wanandroid.system.mvp;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/27  16:28
 * 描    述
 * 修订历史：
 * ================================================
 */
public class WASystemAPI {

    /**
     * 体系数据
     * <p>
     * https://www.wanandroid.com/tree/json
     * <p>
     * 方法：GET
     * 参数：无
     */
    public static final String tree = "https://www.wanandroid.com/tree/json";

    /**
     * 知识体系下的文章
     *
     * https://www.wanandroid.com/article/list/0/json?cid=60
     *
     * 方法：GET
     * 参数：
     * 	cid 分类的id，上述二级目录的id
     * 	页码：拼接在链接上，从0开始。
     */
    public static final String tree_list="https://www.wanandroid.com/article/list/%d/json?cid=%d";
}

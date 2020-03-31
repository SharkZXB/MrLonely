package com.sharkz.wanandroid.home.mvp;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/16  18:27
 * 描    述 1.首页相关
 * 修订历史：
 * ================================================
 */
public class WAHomeAPI {

    /**
     * 首页banner
     * https://www.wanandroid.com/banner/json
     * 方法：GET
     * 参数：无
     */
    public static String Home_Banner="https://www.wanandroid.com/banner/json";

    /**
     * 置顶文章
     * https://www.wanandroid.com/article/top/json
     */
    public static String Home_article_top="https://www.wanandroid.com/article/top/json";

    /**
     * 首页文章列表
     * https://www.wanandroid.com/article/list/0/json
     * 方法：GET
     * 参数：页码，拼接在连接中，从0开始。
     * 注意：除了文字标题，链接，其他字段都可能为null，一定要注意布局下发 null 时的显示情况。
     */
    public static String HOME_article="https://www.wanandroid.com/article/list/%d/json";

    /**
     * 常用网站
     * https://www.wanandroid.com/friend/json
     * 方法：GET
     * 参数：无
     */
    public static String Home_friend="https://www.wanandroid.com/friend/json";

    /**
     * 搜索热词
     * https://www.wanandroid.com/hotkey/json
     * 方法：GET
     * 参数：无
     */
    public static String Home_hotkey="https://www.wanandroid.com/hotkey/json";


}

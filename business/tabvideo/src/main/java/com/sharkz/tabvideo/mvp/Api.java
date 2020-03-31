package com.sharkz.tabvideo.mvp;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020-01-13  13:14
 * 描    述  干货
 * http://gank.io/api
 * https://github.com/dongjunkun/GanK
 * 修订历史：
 * ================================================
 */
public class Api {

    /**
     * 分类数据: http://gank.io/api/data/数据类型/请求个数/第几页
     * •数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * •请求个数： 数字，大于0
     * •第几页：数字，大于0
     * 例：•http://gank.io/api/data/Android/10/1
     * •http://gank.io/api/data/福利/10/1
     * •http://gank.io/api/data/iOS/20/2
     * •http://gank.io/api/data/all/20/2
     * <p>
     * <p>
     * 每日数据： http://gank.io/api/day/年/月/日
     * 例：
     * •http://gank.io/api/day/2015/08/06
     * <p>
     * <p>
     * 随机数据：http://gank.io/api/random/data/
     * •数据类型：福利 | Android | iOS | 休息视频 | 拓展资源 | 前端
     * •个数： 数字，大于0
     * 例：•http://gank.io/api/random/data/Android/20
     */
    public static final String GANHUO = "";

    /**
     * 请求域名
     */
    public static final String BASE_URL = "http://gank.io/api/";

    /**
     * •数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * •请求个数： 数字，大于0
     * •第几页：数字，大于0
     * 分类数据: http://gank.io/api/data/数据类型/请求个数/第几页
     */
    public static final String weal_gank = BASE_URL + "data/福利/";
    public static final String android_gank = BASE_URL + "data/Android/";
    public static final String ios_gank = BASE_URL + "data/iOS/";
    public static final String rest_video_gank = BASE_URL + "data/休息视频/";
    public static final String expand_the_resources_gank = BASE_URL + "data/拓展资源/";
    public static final String h5_gank = BASE_URL + "data/前端/";
    public static final String all_gank = BASE_URL + "data/all/";


}

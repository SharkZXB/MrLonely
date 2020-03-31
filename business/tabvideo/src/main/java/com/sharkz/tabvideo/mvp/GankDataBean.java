package com.sharkz.tabvideo.mvp;

import java.util.List;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020-01-13  13:24
 * 描    述
 * 修订历史：
 * ================================================
 */
public class GankDataBean {

    /**
     * error : false
     * results : [{"_id":"5e03fcc79d212207e200f0a4","createdAt":"2019-12-26T08:20:23.213Z","desc":"自定义文本控件，支持富文本，包含两种状态：编辑状态和预览状态。编辑状态中，可以对插入本地或者网络图片，可以同时插入多张有序图片和删除图片，支持图文混排，并且可以对文字内容简单操作加粗字体，设置字体下划线，支持设置文字超链接(超链接支持跳转)，支持字数和图片数量统计，功能完善中\u2026\u2026","images":["http://img.gank.io/47e11fc4-d522-44a1-ba21-cd6cba4e22d8","http://img.gank.io/fa4b83e8-03f6-4d04-8a3e-8db357cc9238","http://img.gank.io/d8d62f1c-ebc0-4362-a23d-3adbdaf56d79","http://img.gank.io/effcdf25-1a26-48dc-bee7-66374b0af1d5","http://img.gank.io/9ac91b47-5778-4ce3-b534-34b6cd0f975d"],"publishedAt":"2019-12-26T00:21:21.559Z","source":"web","type":"Android","url":"https://github.com/yangchong211/YCCustomText","used":true,"who":"潇湘剑雨"},{"_id":"5dff84839d212267f5ba60a3","createdAt":"2019-12-22T14:58:11.365Z","desc":"RxHttp 一条链发送任意请求，让你眼前一亮的Http请求框架","publishedAt":"2019-12-26T00:20:53.212Z","source":"web","type":"Android","url":"https://juejin.im/post/5ded221a518825125d14a1d4","used":true,"who":"潇湘剑雨"},{"_id":"5df74dcb9d212267f5ba609f","createdAt":"2019-12-16T09:26:35.577Z","desc":"程序员的年底总结，带你了解 Github 爆款的实现。","publishedAt":"2019-12-17T01:06:13.86Z","source":"web","type":"Android","url":"https://juejin.im/post/5df701b751882512290f25f2","used":true,"who":"潇湘剑雨"},{"_id":"5de85d659d212207e200f090","createdAt":"2019-12-05T09:29:09.968Z","desc":"年底了，聊聊年终奖的套路。祝大家都避开套路，多拿大奖","publishedAt":"2019-12-10T02:18:40.231Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s/AavPrNwzF35cn-CUHgz8YQ","used":true,"who":"潇湘剑雨"},{"_id":"5de0678f9d2122688d07a7b0","createdAt":"2019-11-29T00:34:23.854Z","desc":"懒到不想打包，念段咒语！让代码自己打包 ---- 念段咒语！让代码自己打包。","publishedAt":"2019-12-04T02:08:08.101Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s/OBz9rKkdyHBzj3K_893d7A","used":true,"who":"潇湘剑雨"},{"_id":"5dd48a9a9d212267f5ba608b","createdAt":"2019-11-20T00:36:42.846Z","desc":"滴滴老司机开车：启动速度优化","publishedAt":"2019-11-26T11:00:14.569Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s/QbJg4ZR1I6DV6OpFRpFVOQ","used":true,"who":"潇湘剑雨"},{"_id":"5dcdf0659d2122688d07a7a5","createdAt":"2019-11-15T00:25:09.178Z","desc":"继腾讯之后，又有大佬向Flutter热更新动手啦","publishedAt":"2019-11-15T07:53:02.496Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s/5evgUZ6coTH661CL_iotIQ","used":true,"who":"潇湘剑雨"},{"_id":"5dc5353b9d212267f5ba6081","createdAt":"2019-11-08T09:28:27.580Z","desc":"一款Kotlin开发的谷歌material design 设计风格的短视频app","publishedAt":"2019-11-12T01:17:22.146Z","source":"web","type":"Android","url":"https://github.com/Victor2018/FunnyClips","used":true,"who":"潇湘剑雨"},{"_id":"5dba2b3d9d21226808a3e9ae","createdAt":"2019-10-31T00:30:53.178Z","desc":"热更新再牛，也少不了Android 增量更新","publishedAt":"2019-11-02T01:52:53.818Z","source":"web","type":"Android","url":"https://mp.weixin.qq.com/s/Hgf7xMjPTUvmSQ_1WAk_0g","used":true,"who":"潇湘剑雨"},{"_id":"5dbce1239d21226808a3e9af","createdAt":"2019-11-02T01:51:31.58Z","desc":"模仿淘宝、京东、考拉等商品详情页分页加载的UI效果。可以嵌套RecyclerView、WebView、ViewPager、ScrollView等等。","images":["http://img.gank.io/861eaef8-cac5-4af1-88b6-ef00aa3d1e36","http://img.gank.io/94a6b32a-092d-429f-b582-fb543ac84cc8","http://img.gank.io/12a9de19-a5eb-4a52-9b78-7e3a1b3d038e","http://img.gank.io/8a156474-24f0-4bc0-8317-fd006b4ef868"],"publishedAt":"2019-11-02T01:52:00.378Z","source":"web","type":"Android","url":"https://github.com/yangchong211/YCShopDetailLayout/blob/master/README.md","used":true,"who":"潇湘剑雨"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 5e03fcc79d212207e200f0a4
         * createdAt : 2019-12-26T08:20:23.213Z
         * desc : 自定义文本控件，支持富文本，包含两种状态：编辑状态和预览状态。编辑状态中，可以对插入本地或者网络图片，可以同时插入多张有序图片和删除图片，支持图文混排，并且可以对文字内容简单操作加粗字体，设置字体下划线，支持设置文字超链接(超链接支持跳转)，支持字数和图片数量统计，功能完善中……
         * images : ["http://img.gank.io/47e11fc4-d522-44a1-ba21-cd6cba4e22d8","http://img.gank.io/fa4b83e8-03f6-4d04-8a3e-8db357cc9238","http://img.gank.io/d8d62f1c-ebc0-4362-a23d-3adbdaf56d79","http://img.gank.io/effcdf25-1a26-48dc-bee7-66374b0af1d5","http://img.gank.io/9ac91b47-5778-4ce3-b534-34b6cd0f975d"]
         * publishedAt : 2019-12-26T00:21:21.559Z
         * source : web
         * type : Android
         * url : https://github.com/yangchong211/YCCustomText
         * used : true
         * who : 潇湘剑雨
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}

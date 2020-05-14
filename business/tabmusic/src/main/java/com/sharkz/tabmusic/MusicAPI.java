package com.sharkz.tabmusic;

import android.annotation.SuppressLint;
import android.content.Context;

import java.util.Random;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/4/15  16:51
 * 描    述 当前声音来源 喜马拉雅
 * 修订历史：
 * ================================================
 */
public class MusicAPI {


    /**
     * 域名前缀
     */
    public static final String host = "api.ximalaya.com";


    /**
     * 公共参数  公共参数适用于除用户隐私数据API外的所有API；
     *                                                  字段名 	            类型 	必填 	描述
     *                                                  app_key 	        String 	是 	    喜马拉雅开放平台应用公钥
     *                                                  client_os_type 	    Int 	是 	    固定值4，表示是服务端API接入，注意：对于支付API相关接口有client_os_type参数，只能为“1”或“2”，根据具体情况设置
     *                                                  nonce 	            String 	是 	    一个随机字符串，随机性越大越好，每个请求都需要重新生成
     *                                                  timestamp 	        Long 	是 	    当前Unix毫秒数时间戳，每个请求都需要重新生成，与当前时间间隔不要超过一小时，注意：对于分销接口的timestamp参数，与当前时间间隔不要超过5分钟
     *                                                  device_id 	        String 	是 	    设备唯一标识，根据终端类型（Android、iOS、Linux、Web等）不一样生成规则不一样，请参考 设备ID生成说明
     *                                                  server_api_version 	String 	是 	    api版本号，目前为： 1.0.0。
     *                                                  sig 	            String 	是 	    签名参数，对除sig外所有参数进行签名计算得到的值。每次请求都要重新生成，不可复用，sig参数全为小写。请参考 签名生成算法。
     */
    public static final String app_key="app_key";
    public static final int client_os_type=4;
    public static final String server_api_version="1.0.0";
    public static final String sig="sig";


    /**
     * length用户要求产生字符串的长度
     *
     * @param length 随机字符串的长度
     */
    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 当前Unix毫秒数时间戳
     */
    public static Long getTimestamp(){
        return System.currentTimeMillis();
    }

    /**
     *  设备唯一标识
     */
    @SuppressLint("HardwareIds")
    public static String getAndroidId(Context context) {
        return android.provider.Settings.Secure.getString(context.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
    }


    /**
     * 分类列表
     * 接口 /categories/list
     * 功能  获取喜马拉雅点播数据分类列表
     * HTTP  Method  GET
     * 限制  无
     * 参数  公共参数
     * 返回值 返回分类列表，每个分类的字段解释如下：
     *                                      字段名 	            类型 	描述
     *                                      id 	                Int 	分类ID
     *                                      kind 	            String 	固定值"category"
     *                                      category_name 	    String 	分类名称
     *                                      cover_url_small 	String 	分类封面小图
     *                                      cover_url_middle 	String 	分类封面中图
     *                                      cover_url_large 	String 	分类封面大图
     */


}

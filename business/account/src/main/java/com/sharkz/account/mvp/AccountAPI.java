package com.sharkz.account.mvp;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/21  19:07
 * 描    述 账户操作相关API
 * 修订历史：
 * ================================================
 */
public class AccountAPI {

    /**
     * https://www.wanandroid.com/user/login
     * 方法：POST
     * 参数：
     * 	username，password
     */
    public static String login ="https://www.wanandroid.com/user/login";

    /**
     * 注册
     * https://www.wanandroid.com/user/register
     * 方法：POST
     * 参数
     * 	username,password,repassword
     */
    public static String register="https://www.wanandroid.com/user/register";

    /**
     * 退出
     * https://www.wanandroid.com/user/logout/json
     * 方法：GET
     */
    public static String logout="https://www.wanandroid.com/user/logout/json";


}

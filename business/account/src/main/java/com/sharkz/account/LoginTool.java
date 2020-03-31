package com.sharkz.account;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * ================================================
 * 作    者：SharkZ
 * 邮    箱：229153959@qq.com
 * 创建日期：2020/3/21  20:38
 * 描    述 登录工具类 全局的登录/注册/登出都在这里
 * 修订历史：
 * ================================================
 */
public class LoginTool {

    public static AccountCallBack callBack;

    public static void login(Context context,AccountCallBack callBack){
        if (context instanceof Activity){
            LoginTool.callBack=callBack;
            context.startActivity(new Intent(context,LoginActivity.class));
        }else{
            throw new ClassCastException("传入的 context 不是 Activity 类型");
        }
    }

}

/*

    一般面试中java Exception（runtimeException ）是必会被问到的问题
    常见的异常列出四五种，是基本要求。更多的。。。。需要注意积累了

    常见的几种如下：

    NullPointerException - 空指针引用异常
    ClassCastException - 类型强制转换异常。
    IllegalArgumentException - 传递非法参数异常。
    ArithmeticException - 算术运算异常
    ArrayStoreException - 向数组中存放与声明类型不兼容对象异常
    IndexOutOfBoundsException - 下标越界异常
    NegativeArraySizeException - 创建一个大小为负数的数组错误异常
    NumberFormatException - 数字格式异常
    SecurityException - 安全异常
    UnsupportedOperationException - 不支持的操作异常

 */


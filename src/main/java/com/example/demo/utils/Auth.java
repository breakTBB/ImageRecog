package com.example.demo.utils;

import com.baidu.aip.imageclassify.AipImageClassify;

/**
 * @author prism17
 * @email 2839296425@qq.com
 * @Date 20/05/2019 23:25
 **/
public class Auth {
    //设置APPID/AK/SK
    public static final String APP_ID = "16301446";
    public static final String API_KEY = "SGMKllibhNKxwcEgHbuMOocG";
    public static final String SECRET_KEY = "ehDNvmWMQGRT2AM64okeH1MdKcl9lKoU";

    public static AipImageClassify getClient() {
        return new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);
    }
}
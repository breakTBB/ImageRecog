package com.example.demo.utils;

import com.baidu.aip.imageclassify.AipImageClassify;
import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;

/**
 * @author prism17
 * @email 2839296425@qq.com
 * @Date 20/05/2019 23:25
 **/
public class Sample {
    //设置APPID/AK/SK
    public static final String APP_ID = "16301446";
    public static final String API_KEY = "SGMKllibhNKxwcEgHbuMOocG";
    public static final String SECRET_KEY = "ehDNvmWMQGRT2AM64okeH1MdKcl9lKoU";

    public static void main(String[] args) {
        // 初始化一个AipImageClassify
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);
        // 调用接口
        String path = "C:\\Users\\prism\\Pictures\\head.jpg";
        JSONObject res = client.objectDetect(path, new HashMap<String, String>());
        System.out.println(res.toString(2));

    }
}

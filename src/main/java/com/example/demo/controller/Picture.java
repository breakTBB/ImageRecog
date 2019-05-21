package com.example.demo.controller;

import com.baidu.aip.util.Base64Util;
import com.example.demo.utils.Auth;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author prism17
 * @email 2839296425@qq.com
 * @Date 18/05/2019 13:15
 **/
@RestController
public class Picture {

    private static final String filePath = "C:\\Users\\prism\\Desktop\\";

    @RequestMapping(value = "picture")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        //file.isEmpty(); 判断图片是否为空
        //file.getSize(); 图片大小进行判断

//        String name = request.getParameter("name");

        // 获取文件名
        String fileName = file.getOriginalFilename();
        System.out.println("上传的文件名为：" + fileName);

        // 获取文件的后缀名,比如图片的jpeg,png
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传的后缀名为：" + suffixName);
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("baike_num", "5");
        // 文件上传后的路径
        fileName = UUID.randomUUID() + suffixName;


        System.out.println("转换后的名称:" + fileName);


        try {
            File dest = new File(filePath + fileName);
            file.transferTo(dest);
            System.out.println(Auth.getClient().objectDetect(dest.getAbsolutePath(), options));
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }
}

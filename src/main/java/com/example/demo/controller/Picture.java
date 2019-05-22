package com.example.demo.controller;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.example.demo.utils.Auth;
import com.example.demo.utils.Image;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author prism17
 * @email 2839296425@qq.com
 * @Date 18/05/2019 13:15
 **/
@RestController
public class Picture {
    AipImageClassify client = Auth.getClient();
    private static final String filePath = "C:\\Users\\prism\\Desktop\\";
    HashMap<String, String> options = new HashMap<String, String>();
    {
        options.put("baike_num", "5");
    }

    @RequestMapping(value = "picture")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        System.out.println("上传的文件名为：" + fileName);
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传的后缀名为：" + suffixName);

        fileName = UUID.randomUUID() + suffixName;
        System.out.println("转换后的名称:" + fileName);
        try {
            File dest = new File(filePath + fileName);
            file.transferTo(dest);
            JSONObject res = client.plantDetect(dest.getAbsolutePath(), options);
            return res.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping(value = "detect_url")
    public String detect_url(@RequestParam("picUrl") String url) {
        String fn = Image.writeHttpImgToPath(url, filePath, "jpg");
        JSONObject res = client.plantDetect(fn, options);
        return res.toString();
    }
}

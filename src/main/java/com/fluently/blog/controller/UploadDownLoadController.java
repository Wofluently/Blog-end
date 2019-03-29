package com.fluently.blog.controller;

import com.aliyun.oss.OSSClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@RequestMapping("/uploadDownload")
public class UploadDownLoadController {

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
    public String uploadImage(@RequestParam(value = "file") MultipartFile file) throws RuntimeException {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-beijing.aliyuncs.com";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "LTAIXQz7BS0vw70l";
        String accessKeySecret = "IS4rcFF1RstxWckBcrWNx27HCc9hDQ";

        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        // 上传文件流。
        try {
            ossClient.putObject("changlau", file.getOriginalFilename(), file.getInputStream());
        } catch (Exception ex) {
            return "";
        }

        // 关闭OSSClient。
        ossClient.shutdown();
        // 返回访问链接
        return "https://changlau.oss-cn-beijing.aliyuncs.com/" + file.getOriginalFilename();
    }


    //文件下载相关代码
    @RequestMapping(value = "/downloadImage", method = RequestMethod.GET)
    public String downloadImage(@RequestParam(value = "imageName") String imageName, HttpServletRequest request, HttpServletResponse response) {
        String uploadDir = "/root/blog_upload/img/";
        System.out.println("the imageName is : " + imageName);
        String fileUrl = uploadDir + imageName;
        if (fileUrl != null) {
            //当前是从该工程的WEB-INF//File//下获取文件(该目录可以在下面一行代码配置)然后下载到C:\\users\\downloads即本机的默认下载的目录
           /* String realPath = request.getServletContext().getRealPath(
                    "//WEB-INF//");*/
            /*File file = new File(realPath, fileName);*/
            File file = new File(fileUrl);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition",
                        "attachment;fileName=" + imageName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }

}


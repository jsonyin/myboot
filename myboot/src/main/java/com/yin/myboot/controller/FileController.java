package com.yin.myboot.controller;

import com.sun.deploy.net.HttpResponse;
import com.sun.javafx.collections.MappingChange;
import com.yin.myboot.service.impl.FileUploadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by zcy on 2018/1/8.
 */
@RestController
public class FileController {

    @Autowired
    private FileUploadServiceImpl fileUploadService;

    @RequestMapping(value="/api/file/upload",method = RequestMethod.POST)
    public Map fileUpload(MultipartFile uploadfile){
        if(uploadfile != null) {
            return fileUploadService.uploadFIle(uploadfile);
        }else {
            Map result = new HashMap();
            result.put("error","1");
            result.put("messsge","文件不能为空");
            return result;
        }
    }

    /*
        文件下载，通过将response传递执行
     */
    @RequestMapping(value="/api/file/download",method = RequestMethod.GET)
    public void fileDownload(HttpServletResponse response,String fullPath){
        String fileName="cnm"+fullPath.substring(fullPath.indexOf("."));
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File(fullPath)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("success");
    }

}

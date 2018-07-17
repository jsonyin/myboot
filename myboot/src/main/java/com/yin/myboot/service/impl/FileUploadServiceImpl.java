package com.yin.myboot.service.impl;

import com.yin.myboot.service.FileUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zcy on 2018/1/8.
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {
    Logger log= LoggerFactory.getLogger(FileUploadServiceImpl.class);

    @Value("${uploadpath}")
    private String UPLOAD_PATH;
    @Override
    public Map uploadFIle(MultipartFile uploadFile) {
        String oldName = uploadFile.getOriginalFilename();
        String newName = System.currentTimeMillis()+oldName.substring(oldName.indexOf("."));
        Map result = new HashMap();
        String path;
        try {
            path=copy(uploadFile.getInputStream(),newName);
        } catch (IOException e) {
            result.put("error",1);
            result.put("message",e.getMessage());
           return result;
        }
        result.put("error",0);
        result.put("path",path);
        return result;
    }

    private String copy(InputStream fis, String fileName)throws IOException{
        File newFile = new File(UPLOAD_PATH+fileName);
        if(!newFile.exists()){
            try {
                newFile.createNewFile();
            }catch (IOException e){
                log.warn("文件创建失败，文件名{}",newFile.getName());
                throw new IOException("文件创建失败");
            }
        }
        FileOutputStream fos = new FileOutputStream(newFile);
        byte[] b = new byte[1024*50];
        int read;
        while((read=fis.read(b))>0){
            fos.write(b,0,read);
        };
        fis.close();
        fos.close();
        return UPLOAD_PATH+fileName;
    }
}

package com.hou.springmvc.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//文件上传
@RestController
@RequestMapping("/upload")
public class FileUoloadController {

    //使用HttpServletRequest方式上传
    @PostMapping("/request")
    public Map<String,Object> requestUpload(HttpServletRequest request){
        MultipartHttpServletRequest multipart=null;
        if(request instanceof MultipartHttpServletRequest){
            //强转,方便操作文件
            multipart= (MultipartHttpServletRequest) request;
        }else{
            return dealResult(false,"上传失败");
        }
        //获取文件信息
        MultipartFile multipartFile = multipart.getFile("file");
        String filename = multipartFile.getOriginalFilename();//获取文件名
        File file = new File(filename);//配置文件已经定义好存储路径这里直接用文件名即可
        try {
            //保存文件
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            return dealResult(false,"上传失败");
        }
        return dealResult(true,"上传成功");
    }

    //使用MultiPartFile方式上传
    @PostMapping("/multiPart")
    public Map<String,Object> multiPartUpload(MultipartFile file){
        String filename = file.getOriginalFilename();
        File file1 = new File(filename);
        try {
            file.transferTo(file1);
        } catch (IOException e) {
            e.printStackTrace();
            return dealResult(false,"上传失败");
        }
        return dealResult(true,"上传成功");
    }

    //使用part方式,推荐
    @PostMapping("/part")
    public Map<String,Object> partUpload(Part file){//Servlet包
        String fileName = file.getSubmittedFileName();
        try {
            file.write(fileName);//保存文件
        } catch (IOException e) {
            e.printStackTrace();
            return dealResult(false,"上传失败");
        }
        return dealResult(true,"上传成功");
    }

    //处理返回结果
    public Map<String,Object> dealResult(Boolean result,String msg){
        Map<String,Object> map=new HashMap<>();
        map.put("result",result);
        map.put("msg",msg);
        return map;
    }


}

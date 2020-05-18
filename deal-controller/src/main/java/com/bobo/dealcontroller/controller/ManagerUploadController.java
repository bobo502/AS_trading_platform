package com.bobo.dealcontroller.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bobo.deal.ServiceInterface.CategoryService;
import com.bobo.deal.bean.RespBean;
import com.bobo.dealcontroller.util.picUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/manager")
public class ManagerUploadController {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    @Autowired
    picUtil pic;

    @Reference
    CategoryService categoryService;
    @PostMapping("/uploadFile")
    public RespBean upload(HttpServletRequest req, MultipartFile image,int id) throws IOException {
        StringBuffer url = new StringBuffer();
        String upload = pic.singleFileUpload("/university",image);
        url.append(req.getScheme())
                .append("://")
                .append(req.getServerName())
                .append(":")
                .append(req.getServerPort())
                .append(req.getContextPath())
                .append("/image/university/")
                .append(upload);
        categoryService.setLogo(id,url.toString());
        return new RespBean("success", url.toString());

    }
}

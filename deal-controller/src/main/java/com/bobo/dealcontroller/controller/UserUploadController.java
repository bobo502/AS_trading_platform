package com.bobo.dealcontroller.controller;

import com.bobo.deal.bean.RespBean;
import com.bobo.dealcontroller.util.picUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserUploadController {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    /**
     * 上传图片
     * @param req
     * @param image
     * @return
     */
    @Autowired
    picUtil pic;
    @PostMapping("/uploadFile")
    public RespBean upload(HttpServletRequest req, MultipartFile image) throws IOException {
        StringBuffer url = new StringBuffer();
        String upload = pic.singleFileUpload("/school",image);
        url.append(req.getScheme())
                .append("://")
                .append(req.getServerName())
                .append(":")
                .append(req.getServerPort())
                .append(req.getContextPath())
                .append("/image/school/")
                .append(upload);

        return new RespBean("success", url.toString());
    }

    @PostMapping("/uploadGoods")
    public RespBean uploadgoods(HttpServletRequest req, MultipartFile image) throws IOException {
        StringBuffer url = new StringBuffer();
        String upload = pic.singleFileUpload("/Goods",image);
        url.append(req.getScheme())
                .append("://")
                .append(req.getServerName())
                .append(":")
                .append(req.getServerPort())
                .append(req.getContextPath())
                .append("/image/Goods/")
                .append(upload);

        return new RespBean("success", url.toString());
    }
    @PostMapping("/uploadBuy")
    public RespBean uploadBuy(HttpServletRequest req, MultipartFile image) throws IOException {
        StringBuffer url = new StringBuffer();
        String upload = pic.singleFileUpload("/ForBuy",image);
        url.append(req.getScheme())
                .append("://")
                .append(req.getServerName())
                .append(":")
                .append(req.getServerPort())
                .append(req.getContextPath())
                .append("/image/ForBuy/")
                .append(upload);

        return new RespBean("success", url.toString());
    }
    @PostMapping("/uploadHead")
    public RespBean uploadHead(HttpServletRequest req, MultipartFile image) throws IOException {
        StringBuffer url = new StringBuffer();
        String upload = pic.singleFileUpload("/User",image);
        url.append(req.getScheme())
                .append("://")
                .append(req.getServerName())
                .append(":")
                .append(req.getServerPort())
                .append(req.getContextPath())
                .append("/image/User/")
                .append(upload);

        return new RespBean("success", url.toString());
    }
}

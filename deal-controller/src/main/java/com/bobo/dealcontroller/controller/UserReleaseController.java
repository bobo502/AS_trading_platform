package com.bobo.dealcontroller.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bobo.deal.ServiceInterface.ReleaseService;
import com.bobo.deal.bean.Buy_Information;
import com.bobo.deal.bean.Product;
import com.bobo.deal.bean.RespBean;
import com.bobo.deal.bean.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserReleaseController {
    Date date = new Date();
    SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String now  = formatter.format(date);


    @Reference
    ReleaseService releaseService;
    @PostMapping("/release")
    public RespBean release_goods(Product product){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        product.setDate(now);
        product.setUid(user.getUser_id());
        if (releaseService.addgood(product)==1){
            return new RespBean("success","发布成功");
        }
        else return new RespBean("error","发布失败");

    }
    @PutMapping("/release")
    public RespBean release_BuyInfo(Buy_Information buy_information){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        buy_information.setDate(now);
        buy_information.setUid(user.getUser_id());
        if (releaseService.addBuyInfo(buy_information)==1){
            return new RespBean("success","发布成功");
        }
        else return new RespBean("error","发布失败");

    }

    @RequestMapping("/getProduct")
    public List<Product> getProduct(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return releaseService.getProduct(user.getUser_id());
    }
    @PostMapping("/deleteProduct")
    public RespBean deleteProduct(int pid){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        if (releaseService.deleteProductById(pid,user.getUser_id())==1){
            return new RespBean("success","删除成功");
        }
        else return new RespBean("error","删除失败");

    }
    @RequestMapping("/getBuyInfo")
    public List<Buy_Information> getBuyInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return releaseService.getBuyById(user.getUser_id());
    }
    @PostMapping("/deleteBuy")
    public RespBean deleteBuy(int bid){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        if (releaseService.deleteBuyById(bid,user.getUser_id())==1){
            return new RespBean("success","删除成功");
        }
        else return new RespBean("error","删除失败");

    }
}

package com.bobo.dealcontroller.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bobo.deal.ServiceInterface.ShowService;
import com.bobo.deal.bean.Buy_Information;
import com.bobo.deal.bean.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/open")
public class UserShowController {
    @Reference
    ShowService showService;

    @RequestMapping("/getProductList")
    public List<Product> getProduct(int rid,String keywords,int count, int page ){
        return showService.getProduct(page,count,rid,keywords);
    }
    @RequestMapping("/productCount")
    public Integer productCount(){
        return showService.productCount();
    }

    @RequestMapping("/productDetail")
    public HashMap productDetail(int pid){
        return showService.getProductDetail(pid);
    }
    @RequestMapping("/getBuyInfo")
    public List<Buy_Information> getBuyInfo(int count, int page ){
        return showService.getBuyInfo(page,count);
    }
    @RequestMapping("/BuyInfoCount")
    public Integer BuyInfoCount(){
        return showService.BuyInfoCount();
    }
}

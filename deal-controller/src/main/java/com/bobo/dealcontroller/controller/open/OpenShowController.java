package com.bobo.dealcontroller.controller.open;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bobo.deal.ServiceInterface.ShowService;
import com.bobo.deal.bean.Buy_Information;
import com.bobo.deal.bean.Comment;
import com.bobo.deal.bean.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/open")
public class OpenShowController {
    @Reference
    ShowService showService;

    //商品展示
    @RequestMapping("/getProductList")
    public List<Product> getProduct(int rid,String keywords,int count, int page ){
        return showService.getProduct(page,count,rid,keywords);
    }
    @RequestMapping("/productCount")
    public Integer productCount(){
        return showService.productCount();
    }

    //商品详情
    @RequestMapping("/productDetail")
    public HashMap productDetail(int pid){
        return showService.getProductDetail(pid);
    }

    //求购信息
    @RequestMapping("/getBuyInfo")
    public List<Buy_Information> getBuyInfo(int count, int page ){
        return showService.getBuyInfo(page,count);
    }
    @RequestMapping("/BuyInfoCount")
    public Integer BuyInfoCount(){
        return showService.BuyInfoCount();
    }

    //商品评论
    @RequestMapping("/getCommentList")
    public List<Comment> getCommentList(int product_id,int page,int count){
        return showService.getComment(product_id,page,count);
    }
    @RequestMapping("/getCommentCount")
    public Integer getCommentCount(int product_id){
        return showService.getCommentCount(product_id);
    }
}

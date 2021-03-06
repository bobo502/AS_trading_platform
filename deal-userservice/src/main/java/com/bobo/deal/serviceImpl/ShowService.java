package com.bobo.deal.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bobo.deal.bean.*;
import com.bobo.deal.mapper.CommentMapper;
import com.bobo.deal.mapper.ShowMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ShowService implements com.bobo.deal.ServiceInterface.ShowService {
    @Autowired
    ShowMapper showMapper;

    @Autowired
    CommentMapper commentMapper;
    @Override
    public List<Product> getProduct(int page, int count,int rid, String keywords) {
        int start = (page - 1) * count;
        ArrayList<Product> lists=showMapper.getProduct(keywords,rid,start,count);
        for(int i=0;i<lists.size();i++){
            Product product=lists.get(i);
            String [] photos= showMapper.getPhotos(product.getProduct_id()).toArray(new String[0]);
            String [] tags= showMapper.getTags(product.getProduct_id()).toArray(new String[0]);
            product.setPhotos(photos);
            product.setTags(tags);
        }
        return lists;
    }

    @Override
    public Integer productCount(){
        return showMapper.productCount();
    }

    @Override
    public HashMap getProductDetail(int pid){
        Product product= showMapper.getProductDetail(pid);
        String [] photos= showMapper.getPhotos(product.getProduct_id()).toArray(new String[0]);
        String [] tags= showMapper.getTags(product.getProduct_id()).toArray(new String[0]);
        product.setPhotos(photos);
        product.setTags(tags);
        UserMsg userMsg=showMapper.getUser(product.getUid());
        String university=showMapper.getUniversity(userMsg.getUniversity_id());
        HashMap hashMap=new HashMap();
        hashMap.put("product",product);
        hashMap.put("user",userMsg);
        hashMap.put("university",university);
        return hashMap;

    }
    @Override
    public List<Buy_Information> getBuyInfo(int page, int count) {
        int start = (page - 1) * count;
        List<Buy_Information> lists=showMapper.getBuyInfo(start,count);
        for(int i=0;i<lists.size();i++){
            Buy_Information buy_information=lists.get(i);
            String [] tags= showMapper.getBuyTags(buy_information.getBuy_id()).toArray(new String[0]);
            buy_information.setTags(tags);
        }
        return lists;
    }

    @Override
    public Integer BuyInfoCount(){
        return showMapper.BuyInfoCount();
    }

    @Override
    public List<Comment> getComment(int product_id,int page, int count) {
        int start = (page - 1) * count;
        return commentMapper.getComment(product_id,start,count);
    }

    @Override
    public Integer getCommentCount(int product_id) {
        return commentMapper.getCommentCount(product_id);
    }
}

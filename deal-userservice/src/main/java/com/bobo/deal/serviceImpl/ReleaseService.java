package com.bobo.deal.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bobo.deal.bean.Buy_Information;
import com.bobo.deal.bean.Product;
import com.bobo.deal.mapper.ReleaseMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ReleaseService implements com.bobo.deal.ServiceInterface.ReleaseService {
    @Autowired
    ReleaseMapper releaseMapper;
    public int addgood(Product product){
        if(releaseMapper.addgood(product)==1){
            String [] photos = product.getPhotos();
            String [] tags=product.getTags();
            for(int i=0;i<photos.length;i++){
                releaseMapper.addphoto(product.getProduct_id(),photos[i]);
            }
            for(int i=0;i<tags.length;i++){
                releaseMapper.addtag(product.getProduct_id(),tags[i]);
            }
            return 1;
        }
        else return 2;
    }

    public int addBuyInfo(Buy_Information buy_information) {
        if(releaseMapper.addBuyInfo(buy_information)==1){
            String[] tags=buy_information.getTags();
            for (int i=0;i<tags.length;i++){
                releaseMapper.addBuyTags(buy_information.getBuy_id(),tags[i]);
            }
            return 1;
        }
        else return 2;
    }

    public List<Product> getProduct(int id){
        return releaseMapper.getProduct(id);
    }

    public int deleteProductById(int pid,int uid){
        if(releaseMapper.deleteProductById(pid,uid)==1){
            releaseMapper.deletePhotos(pid);
            releaseMapper.deleteTags(pid);
            return 1;
        }
        else
        return 2;
    }
    public List<Buy_Information> getBuyById(int id){
        return releaseMapper.getBuyInfo(id);
    }
    public int deleteBuyById(int bid,int uid){

        if (releaseMapper.deleteBuyById(bid, uid) ==1 && releaseMapper.deleteBuyTags(bid)==1)
            return 1;
        else
            return 0;
    }
}

package com.bobo.deal.ServiceInterface;

import com.bobo.deal.bean.Buy_Information;
import com.bobo.deal.bean.Product;

import java.util.List;

public interface ReleaseService {
    int addgood(Product product);
    int addBuyInfo(Buy_Information buy_information);
    List<Product> getProduct(int id);
    int deleteProductById(int pid,int uid);
    List<Buy_Information> getBuyById(int id);
    int deleteBuyById(int bid,int uid);
}

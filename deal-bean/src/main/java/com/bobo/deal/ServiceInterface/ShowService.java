package com.bobo.deal.ServiceInterface;

import com.bobo.deal.bean.Buy_Information;
import com.bobo.deal.bean.Product;

import java.util.HashMap;
import java.util.List;

public interface ShowService {
    List<Product> getProduct(int page, int count,int rid, String keywords);
    Integer productCount();
    HashMap getProductDetail(int pid);
    List<Buy_Information> getBuyInfo(int page, int count);
    Integer BuyInfoCount();
}

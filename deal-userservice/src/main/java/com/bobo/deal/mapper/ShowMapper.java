package com.bobo.deal.mapper;

import com.bobo.deal.bean.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface ShowMapper {
    ArrayList<Product> getProduct(@Param("keywords") String keywords, @Param("rid") int rid, @Param("start") int start, @Param("count") int count);
    List<String> getPhotos(@Param("pid") int pid);
    List<String> getTags(@Param("pid") int pid);
    int productCount();
    Product getProductDetail(@Param("pid") int pid);
    UserMsg getUser(@Param("uid") int uid);
    String getUniversity(@Param("id") int id);

    List<Buy_Information> getBuyInfo(@Param("start") int start, @Param("count") int count);
    List<String> getBuyTags(@Param("bid") int bid);
    Integer BuyInfoCount();
}

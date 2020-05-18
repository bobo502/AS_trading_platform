package com.bobo.deal.mapper;

import com.bobo.deal.bean.Buy_Information;
import com.bobo.deal.bean.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReleaseMapper {
   int addgood(Product product);
   int addphoto(@Param("pid") int pid ,@Param("photo") String photo);
   int addtag(@Param("pid") int pid,@Param("tag") String tag);
   int addBuyInfo(Buy_Information buy_information);
   int addBuyTags(@Param("bid") int bid,@Param("tag") String tag);
   List<Product> getProduct(@Param("id") int id);
   int deleteProductById(@Param("pid") int pid,@Param("uid") int uid);
   List<Buy_Information> getBuyInfo(@Param("id") int id);
   int deleteBuyById(@Param("bid") int bid,@Param("uid") int uid);
   int deletePhotos(@Param("pid") int pid);
   int deleteTags(@Param("pid") int  pid);
   int deleteBuyTags(@Param("bid") int bid);
}

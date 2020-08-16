package com.bobo.manager.mapper;

import com.bobo.deal.bean.Category;
import com.bobo.deal.bean.Reclassify;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {
    //一级分类的增删改查
    int addCategory(@Param("category") String category);
    List<Category> queryall();
    Integer queryCount();
    int change(@Param("id") int id,@Param("category") String category);
    int delete(@Param("id") int id);

    //二级分类的增删改查
    int addReclassify(@Param("cid") int cid,@Param("reclassify") String reclassify);
    List<Reclassify> queryReclassifyAll(@Param("cid") int cid);
    int setLogo(@Param("id") int id,@Param("url") String url);
    int deleteReclassify(@Param("id") int id);
}

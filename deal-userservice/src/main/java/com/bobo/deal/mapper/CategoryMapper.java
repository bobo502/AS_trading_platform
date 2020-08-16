package com.bobo.deal.mapper;

import com.bobo.deal.bean.Category;
import com.bobo.deal.bean.Reclassify;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<Category> queryall();
    List<Reclassify> queryByid(@Param("id") int id);
}

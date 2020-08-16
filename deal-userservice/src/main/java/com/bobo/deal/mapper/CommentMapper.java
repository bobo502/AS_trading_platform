package com.bobo.deal.mapper;

import com.bobo.deal.bean.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<Comment> getComment(@Param("product_id") int product_id,@Param("start") int start ,@Param("count") int count);
    Integer getCommentCount(@Param("product_id") int product_id);
}

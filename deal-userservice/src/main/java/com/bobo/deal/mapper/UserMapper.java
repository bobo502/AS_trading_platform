package com.bobo.deal.mapper;

import com.bobo.deal.bean.User;
import com.bobo.deal.bean.UserMsg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    Integer UserRegister(User user);
    User getByEmail(@Param("email") String email);
    int setUser(UserMsg user);
    int setUniversity(@Param("id") int id,@Param("user_id") int user_id);
}

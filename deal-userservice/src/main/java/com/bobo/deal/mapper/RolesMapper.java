package com.bobo.deal.mapper;

import com.bobo.deal.bean.Roles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RolesMapper {
    int addRoles(@Param("rid") Integer rid,@Param("uid") Integer uid );
    List<Roles> getRoleByUid(Integer uid);
}

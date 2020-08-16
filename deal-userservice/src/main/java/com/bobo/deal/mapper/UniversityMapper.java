package com.bobo.deal.mapper;


import com.bobo.deal.bean.University;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UniversityMapper {
    University getNameById(@Param("id") Integer id);
    int AddUniversity(@Param("university") String university,@Param("url") String url);
    List<University> getAll();
}

package com.bobo.manager.mapper;

import com.bobo.deal.bean.University;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UniversityMapper {
    public List<University> getAllUniversity();
}

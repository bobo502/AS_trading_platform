package com.bobo.manager.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.bobo.deal.ServiceInterface.MangerUniversity;
import com.bobo.deal.bean.University;
import com.bobo.manager.mapper.UniversityMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UniversityService implements MangerUniversity {
    @Autowired
    UniversityMapper universityMapper;
    public List<University> getAllUniversity() {
        return universityMapper.getAllUniversity();
    }
}

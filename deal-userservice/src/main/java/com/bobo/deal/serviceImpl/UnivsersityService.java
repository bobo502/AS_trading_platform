package com.bobo.deal.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bobo.deal.ServiceInterface.UniversityService;
import com.bobo.deal.bean.University;
import com.bobo.deal.mapper.UniversityMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class UnivsersityService implements UniversityService {
    @Autowired
    UniversityMapper universityMapper;
    public int AddUniversity(String university,String url){
        return universityMapper.AddUniversity(university,url);
    }
    public List<University> getAll(){
        return universityMapper.getAll();
    }
}

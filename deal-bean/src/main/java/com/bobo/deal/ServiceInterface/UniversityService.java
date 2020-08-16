package com.bobo.deal.ServiceInterface;

import com.bobo.deal.bean.University;

import java.util.List;

public interface UniversityService {
    int AddUniversity(String university,String url);
    List<University> getAll();
}

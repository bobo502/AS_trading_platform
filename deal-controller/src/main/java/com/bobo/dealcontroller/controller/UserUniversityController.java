package com.bobo.dealcontroller.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bobo.deal.ServiceInterface.UniversityService;
import com.bobo.deal.bean.RespBean;
import com.bobo.deal.bean.University;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserUniversityController {

    @Reference
    UniversityService universityService;
    @PostMapping("/AddUniversity")
    public RespBean addUniversity(String university,String url){
        if (universityService.AddUniversity(university,url)==1){
            return new RespBean("success","提交成功");
        }
        else return new RespBean("error","提交失败");
    }
    @GetMapping("/getAll")
    public List<University> getAll(){
        return universityService.getAll();
    }
}

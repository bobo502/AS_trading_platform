package com.bobo.dealcontroller.controller.manager;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bobo.deal.ServiceInterface.MangerUniversity;
import com.bobo.deal.bean.University;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerUniversityController {
    @Reference
    MangerUniversity mangerUniversity;

    @RequestMapping("/getAllUniversity")
    public List<University> getAllUniversity(){
        return mangerUniversity.getAllUniversity();
    }
}

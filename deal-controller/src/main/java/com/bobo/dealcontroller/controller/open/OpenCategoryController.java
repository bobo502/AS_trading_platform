package com.bobo.dealcontroller.controller.open;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bobo.deal.ServiceInterface.UserCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/open")
public class OpenCategoryController {

    @Reference
    UserCategoryService categoryService;
    @RequestMapping("/query")
    public List query(){
        return categoryService.query();
    }
}

package com.bobo.dealcontroller.controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bobo.deal.ServiceInterface.UserService;
import com.bobo.deal.bean.RespBean;
import com.bobo.deal.bean.User;
import com.bobo.deal.bean.UserMsg;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserPersonController {
    @Reference
    UserService userService;
    @RequestMapping("/getUser")
    public User getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return user;
    }
    @PostMapping("/setMsg")
    public RespBean setMsg(UserMsg user){
        if (userService.setUser(user)==1){
            return new RespBean("success","修改成功！");
        }
        else return new RespBean("error","修改失败！");
    }
    @PostMapping("/setUniversity")
    public RespBean setUniversity(int id,int user_id){
        if (userService.setUniversity(id,user_id)==1){
            return new RespBean("success","修改成功！");
        }
        else return new RespBean("error","修改失败！");
    }
}

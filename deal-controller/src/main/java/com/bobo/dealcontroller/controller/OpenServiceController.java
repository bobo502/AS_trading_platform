package com.bobo.dealcontroller.controller;

import com.bobo.deal.bean.RespBean;
import com.bobo.deal.bean.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/open")
public class OpenServiceController {
    @RequestMapping("/getauth")
    public String getauth(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> auth = authentication.getAuthorities();
        return auth.toString();
    }
    @RequestMapping("/text")
    public int text(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Collection<? extends GrantedAuthority> auth = authentication.getAuthorities();
        User user = (User) authentication.getPrincipal();
        return user.getUser_id();
    }
    @RequestMapping("/success_logout")
    public RespBean success_logout(){
        return new RespBean("success","注销成功！");
    }
    @RequestMapping("/success_fault")
    public RespBean success_fault(){
        return new RespBean("fault","注销失败！");
    }
}

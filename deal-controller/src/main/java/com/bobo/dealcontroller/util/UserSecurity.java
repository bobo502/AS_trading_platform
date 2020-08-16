package com.bobo.dealcontroller.util;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurity implements UserDetailsService {
    @Reference
    com.bobo.deal.ServiceInterface.UserService userService;
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userService.loadUserByUsername(s);
    }
}

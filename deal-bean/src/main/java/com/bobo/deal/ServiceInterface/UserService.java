package com.bobo.deal.ServiceInterface;

import com.bobo.deal.bean.User;
import com.bobo.deal.bean.UserMsg;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService{
    int UserRegister(User user);
    UserDetails loadUserByUsername(String s);
    int setUser(UserMsg user);
    int setUniversity(int id,int user_id);
}

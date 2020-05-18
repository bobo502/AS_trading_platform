package com.bobo.deal.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bobo.deal.ServiceInterface.UserService;
import com.bobo.deal.bean.Roles;
import com.bobo.deal.bean.User;
import com.bobo.deal.bean.UserMsg;
import com.bobo.deal.mapper.RolesMapper;
import com.bobo.deal.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RolesMapper rolesMapper;

    /**
     * 0代表成功，1代表邮箱以存在，2代表失败
     */
    public int UserRegister(User user) {
        //检查是否存在注册的邮箱，是返回1
        User user1 = userMapper.getByEmail(user.getEmail());
        if(user1!=null){
            return 1;
        }
        Integer id = userMapper.UserRegister(user);
        System.out.println(id);
        if(id==1){
            User user2 = userMapper.getByEmail(user.getEmail());
            int i = rolesMapper.addRoles(1,user2.getUser_id());
            if(i==1&&id==1){
                return 0;
            }
            else {
                return 3;
            }
        }
        return 4;
    }

    /**
     * spring-security获取用户信息
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userMapper.getByEmail(s);
        if (user == null) {
            //避免返回null，这里返回一个不含有任何值的User对象，在后期的密码比对过程中一样会验证失败
            return new User();
        }
        List<Roles> roles = rolesMapper.getRoleByUid(user.getUser_id());
        user.setRoles(roles);
        return user;
    }

    public int setUser(UserMsg user){
        return userMapper.setUser(user);
    }

    public int setUniversity(int id,int user_id){
        return userMapper.setUniversity(id,user_id);
    }
}

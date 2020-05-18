package com.bobo.deal.bean;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class User implements Serializable, UserDetails {
    private Integer user_id;
    private String nickname;
    private String head_portrait;
    private Integer university_id; //学校id
    private String email;
    private String real_name;
    private Integer sex;//0代表女生，1代表男生
    private String personalized_signature;//个性签名
    private Integer count;
    private String password;
    private String qq;
    private String wechat;
    private List<Roles> roles;

    public List<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList();
        for (Roles role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoles()));
        }
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return email;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }
}

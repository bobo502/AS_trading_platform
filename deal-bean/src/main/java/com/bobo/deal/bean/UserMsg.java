package com.bobo.deal.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserMsg implements Serializable {
    private Integer user_id;
    private String nickname;
    private String head_portrait;
    private String real_name;
    private Integer sex;//0代表女生，1代表男生
    private String personalized_signature;//个性签名
    private Integer count;
    private String qq;
    private String wechat;
    private Integer university_id; //学校id
    private String email;
}

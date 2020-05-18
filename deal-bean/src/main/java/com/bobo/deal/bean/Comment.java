package com.bobo.deal.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Comment implements Serializable {
    private Integer comment_id;
    private Integer uid;
    private Integer product_id;
    private Integer stars;
    private String context;
}

package com.bobo.deal.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Tags implements Serializable {
    private Integer id;
    private Integer pid;
    private String tag;
}

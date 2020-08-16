package com.bobo.deal.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Category implements Serializable {
    private Integer id;
    private String category;
}

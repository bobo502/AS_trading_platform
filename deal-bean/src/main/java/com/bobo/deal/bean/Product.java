package com.bobo.deal.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Product implements Serializable {
    private Integer product_id;
    private String title;
    private String intro;
    private String bid_price;
    private String original_price;
    private Integer reclassify_id;
    private String postage;
    private String date;
    private String [] tags;
    private String [] photos;
    private Integer uid;
}

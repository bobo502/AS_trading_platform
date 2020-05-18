package com.bobo.deal.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Buy_Information implements Serializable {
    private Integer buy_id;
    private String title;
    private String intro;
    private String buy_price;
    private Integer uid;
    private String photos;
    private String [] tags;
    private String date;
    private UserMsg userMsg;
}

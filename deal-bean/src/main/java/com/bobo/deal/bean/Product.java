package com.bobo.deal.bean;


import lombok.Data;
import org.springframework.boot.convert.DataSizeUnit;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
public class Product implements Serializable{
    private Integer product_id;

    @NotNull(message = "商品标题不能为空")
    @Size(min = 6, max = 11, message = "账号长度必须是1-11个字符")
    private String title;

    @NotNull(message = "商品标题不能为空")
    private String intro;

    @NotNull(message = "商品标题不能为空")
    private String bid_price;

    @NotNull(message = "商品标题不能为空")
    private String original_price;

    @NotNull(message = "商品标题不能为空")
    private Integer reclassify_id;

    @NotNull(message = "商品标题不能为空")
    private String postage;

    @NotNull(message = "商品标题不能为空")
    private String date;

    @NotNull(message = "商品标题不能为空")
    private String [] tags;

    @NotNull(message = "商品标题不能为空")
    private String [] photos;


    private Integer uid;
}

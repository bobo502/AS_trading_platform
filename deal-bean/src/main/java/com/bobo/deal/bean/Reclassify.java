package com.bobo.deal.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Reclassify implements Serializable {
    private Integer reclassify_id;
    private Integer cid;
    private String reclassify;
    private String url;
}

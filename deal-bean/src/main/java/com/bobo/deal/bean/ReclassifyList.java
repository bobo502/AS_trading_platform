package com.bobo.deal.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReclassifyList implements Serializable {
    private Integer reclassify_id;
    private Integer value;
    private String label;
    private String url;
}

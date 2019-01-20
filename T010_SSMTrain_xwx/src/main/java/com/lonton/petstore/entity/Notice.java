package com.lonton.petstore.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Notice {
    private Integer id;
    private String title;
    private Integer createdUser;
    private Date createdTime;
    private String content;
}
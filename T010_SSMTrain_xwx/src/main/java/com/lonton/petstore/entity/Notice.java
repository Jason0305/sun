package com.lonton.petstore.entity;

import java.util.Date;

public class Notice {
    private Integer id;

    private String title;

    private Integer createdUser;

    private Date createdTime;

    private String content;

    public Notice(Integer id, String title, Integer createdUser, Date createdTime, String content) {
        this.id = id;
        this.title = title;
        this.createdUser = createdUser;
        this.createdTime = createdTime;
        this.content = content;
    }

    public Notice() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(Integer createdUser) {
        this.createdUser = createdUser;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
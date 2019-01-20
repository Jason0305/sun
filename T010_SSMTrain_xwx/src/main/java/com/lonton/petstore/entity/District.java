package com.lonton.petstore.entity;

import lombok.Data;

@Data
public class District {
    private Integer id;
    private String parent;
    private String code;
    private String name;
    
    public District() {
    }
    
    public District(Integer id, String parent, String code, String name) {
        this.id = id;
        this.parent = parent;
        this.code = code;
        this.name = name;
    }
}
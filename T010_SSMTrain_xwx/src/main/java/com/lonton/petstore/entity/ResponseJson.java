package com.lonton.petstore.entity;

import lombok.Data;

/**
 *
 * @author 许万兴
 */
@Data
public class ResponseJson<T> {
    
    private int    status = 600;
    private String msg;
    private T      data;
    
    public ResponseJson() {
        super();
    }
    
    public ResponseJson(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
    
    public ResponseJson(T data) {
        this.data = data;
    }
}

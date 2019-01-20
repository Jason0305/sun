package com.lonton.petstore.entity;

import lombok.Data;

/**
 *
 * @author 许万兴
 */
@Data
public class ResponseResult<T> {
    
    private int    status = 600;
    private String msg;
    private T      data;
    
    public ResponseResult() {
        super();
    }
    
    public ResponseResult(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
    
    public ResponseResult(T data) {
        this.data = data;
    }
}

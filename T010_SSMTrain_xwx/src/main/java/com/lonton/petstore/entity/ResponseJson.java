package com.lonton.petstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author 许万兴
 */
@Data@AllArgsConstructor()
public class ResponseJson<T> {
    
    private int    responseStatusCode = 600;
    private String msg;
    private T      data;
    
    public ResponseJson() {
        super();
    }
    
    public ResponseJson(int responseStatusCode, String msg) {
        this.responseStatusCode = responseStatusCode;
        this.msg = msg;
    }
    
    public ResponseJson(T data) {
        this.data = data;
    }
}

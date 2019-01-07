package com.lonton.petstore.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author 许万兴
 */
@Data
public class ResponseJson<T> {
    
    private int    responseStatusCode = 600;
    private String msg;
    private T      data;
    @Override
    public String toString() {
        return "ResponseJson{" +
                "responseStatusCode=" + responseStatusCode +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
    
    public ResponseJson() {
    }
    
    public ResponseJson(int responseStatusCode, String msg) {
        this.responseStatusCode = responseStatusCode;
        this.msg = msg;
    }
    
    public ResponseJson(T data) {
        this.data = data;
    }
    
    public int getResponseStatusCode() {
        return responseStatusCode;
    }
    
    public void setResponseStatusCode(int responseStatusCode) {
        this.responseStatusCode = responseStatusCode;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public T getData() {
        return data;
    }
    
    public void setData(T data) {
        this.data = data;
    }
}

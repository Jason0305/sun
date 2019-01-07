package com.lonton.petstore.controller;

import com.lonton.petstore.entity.ResponseJson;
import com.lonton.petstore.services.exceptions.DataInsertException;
import com.lonton.petstore.services.exceptions.PasswordNotMatchException;
import com.lonton.petstore.services.exceptions.ServiceException;
import com.lonton.petstore.services.exceptions.UserNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 许万兴
 */
public class CenterController {
    
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResponseJson<?> exceptionAction(ServiceException e) {
        if (e instanceof UserNotFoundException) {
            return new ResponseJson<Void>(601, e.getMessage());
        } else if (e instanceof PasswordNotMatchException) {
            return new ResponseJson<Void>(602, e.getMessage());
        } else if (e instanceof DataInsertException) {
            return new ResponseJson<Void>(601, e.getMessage());
        }else{
            return new ResponseJson<>(604, "系统忙，请稍后重试！");
        }

    }
    
}

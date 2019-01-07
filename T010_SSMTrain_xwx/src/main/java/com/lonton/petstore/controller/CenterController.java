package com.lonton.petstore.controller;

import com.lonton.petstore.entity.ResponseJson;
import com.lonton.petstore.services.exceptions.DataInsertException;
import com.lonton.petstore.services.exceptions.PasswordNotMatchException;
import com.lonton.petstore.services.exceptions.ServiceException;
import com.lonton.petstore.services.exceptions.UserNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 许万兴
 */
@Controller
public class CenterController {
    
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResponseJson<?> exceptionAction(Exception e) {
        System.out.println("exception");
        String msg = e.getMessage();
        if (e instanceof UserNotFoundException) {
            return new ResponseJson<Void>(601, msg);
        } else if (e instanceof PasswordNotMatchException) {
            return new ResponseJson<Void>(602, msg);
        } else if (e instanceof DataInsertException) {
            return new ResponseJson<Void>(603, msg);
        }else{
            return new ResponseJson<>(600, "系统忙，请稍后重试！");
        }
    }
    
}

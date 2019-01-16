package com.lonton.petstore.controller;

import com.lonton.petstore.entity.ResponseJson;
import com.lonton.petstore.services.exceptions.DataInsertException;
import com.lonton.petstore.services.exceptions.PasswordNotMatchException;
import com.lonton.petstore.services.exceptions.ServiceException;
import com.lonton.petstore.services.exceptions.UserNotFoundException;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 中心控制器。
 *
 * @author xuwanxing
 */
@Log4j
@Controller
public class CenterController {
    
    /**
     * 异常处理。
     *
     * @param e 之类异常
     * @return json对象
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResponseJson<?> exceptionAction(Exception e) {
        log.info("exception");
        String msg = e.getMessage();
        if (e instanceof UserNotFoundException) {
            return new ResponseJson<Void>(601, msg);
        } else if (e instanceof PasswordNotMatchException) {
            return new ResponseJson<Void>(602, msg);
        } else if (e instanceof DataInsertException) {
            return new ResponseJson<Void>(603, msg);
        } else {
            return new ResponseJson<>(600, "系统忙，请稍后重试！");
        }
    }
    
    
    /**
     * 从Session中获取当前登录的用户的id。
     *
     * @param session HttpSession
     * @return 当前登录的用户的id
     */
    protected final Integer getUidFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("uid").toString());
    }
}

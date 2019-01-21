package com.lonton.petstore.controller;

import com.lonton.petstore.entity.ResponseResult;
import com.lonton.petstore.services.exceptions.DataInsertException;
import com.lonton.petstore.services.exceptions.PasswordNotMatchException;
import com.lonton.petstore.services.exceptions.ServiceException;
import com.lonton.petstore.services.exceptions.UserNotFoundException;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 中心控制器。
 *
 * @author xuwanxing
 */
@Log4j
@Controller
@RequestMapping
public class CenterController {
    
    /**
     * 异常处理。
     *
     * @param e 之类异常
     * @return json对象
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public ResponseResult<?> exceptionAction(Exception e) {
        log.info("exception");
        String msg = e.getMessage();
        if (e instanceof UserNotFoundException) {
            return new ResponseResult<Void>(601, msg);
        } else if (e instanceof PasswordNotMatchException) {
            return new ResponseResult<Void>(602, msg);
        } else if (e instanceof DataInsertException) {
            return new ResponseResult<Void>(603, msg);
        } else {
            return new ResponseResult<>(600, "系统忙，请稍后重试！");
        }
    }
    
    @RequestMapping(value="/index.do")
    public String index(){
        return "index";
    }
    
    @RequestMapping(value="/header_navbar.do")
    public String headerNavbar(){
        return "header_navbar";
    }
    
    @RequestMapping(value="/footer_navbar.do")
    public String footerNavbar(){
        return "footer_navbar";
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

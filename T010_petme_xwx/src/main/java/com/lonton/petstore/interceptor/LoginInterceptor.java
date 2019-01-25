package com.lonton.petstore.interceptor;

import lombok.extern.log4j.Log4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @author xuwanxing
 */
@Log4j
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 获取Session
        HttpSession session = request.getSession();
        // 判断session中是否有登录信息
        return true;
//        if (session.getAttribute("username") == null) {
//            // 没有登录信息，则：重定向到登录页
//        log.info("LoginInterceptor.preHandle()");
//            response.sendRedirect(request.getContextPath() + "/user/login.do");
//            // 执行拦截
//            return false;
//        } else {
//            // 有登录信息，则：允许正常访问，直接放行
//            return true;
//        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
//        log.info("LoginInterceptor.postHandle()");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
//        log.info("LoginInterceptor.afterCompletion()");
    }
}

package com.lonton.petstore.controller;

import com.lonton.petstore.entity.ResponseResult;
import com.lonton.petstore.entity.User;
import com.lonton.petstore.services.IUserService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 用户控制器。
 *
 * @author xuwanxing
 */
@Log4j
@Controller
@RequestMapping("/user")
public class UserController extends CenterController {
    
    @Autowired
    private IUserService userService;
    
    @RequestMapping("/reg.do")
    private String register() {
        return "register";
    }
    
    @ResponseBody
    @RequestMapping(value = "/handle_reg.do", method = RequestMethod.GET)
    private ResponseResult registerAction(@RequestParam("username") String username,
                                          @RequestParam("password") String password,
                                          @RequestParam(value = "gender", required = false,defaultValue = "1") int gender,
                                          String phone, String email) {
        //        userService.checkUsername(username);
        //        userService.checkPassword(password);
        //        userService.checkGender(gender);
        User user = userService.register(new User(username, password, gender, email, phone));
        return new ResponseResult<User>(user);
    }
    
    /**
     * 用户名验证
     *
     * @param username 用户名
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/username_check.do", method = RequestMethod.GET)
    private ResponseResult usernameCheck(@RequestParam("username") String username) {
        //        userService.getUserByUsername(username);
        log.warn("username:" + username);
        return new ResponseResult();
    }
    
    /**
     *
     * @return 返回html页面
     */
    @RequestMapping("/login.do")
    private String loginPage() {
        log.warn("login.do....");
        return "login";
    }
    
    @ResponseBody
    @RequestMapping(value = "/handle_login.do", method = RequestMethod.GET)
    private ResponseResult loginAction(@RequestParam("username") String username,
                                       @RequestParam("password") String password,
                                       HttpSession session) {
        log.info("username = " + username + ",password = " + password);
        User user = userService.login(username, password);
        // 将uid和username封装到Session中
        session.setAttribute("uid", user.getId());
        session.setAttribute("username", user.getUsername());
        return new ResponseResult<User>(user);
    }
    
}

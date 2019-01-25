package com.lonton.petstore.controller;

import com.lonton.petstore.entity.ResponseJson;
import com.lonton.petstore.entity.User;
import com.lonton.petstore.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制器。
 *
 * @Author xuwanxing
 */
@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private IUserService userService;
    
    @ResponseBody
    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
    private ResponseJson registerAction(@RequestParam("username") String username,
                                        @RequestParam("password") String password,
                                        @RequestParam(value = "gender", required = false, defaultValue = "1") int gender,
                                        String phone, String email) {
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        User user = userService.register(new User(username, password, gender, phone, email));
        return new ResponseJson<User>(user);
    }
    
    @ResponseBody
    @RequestMapping(value = "/login.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    private String loginAction(@RequestParam("username") String username,
                               @RequestParam("password") String password) {
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        User user = userService.login(username, password);
        System.out.println("user = " + user);
        return "{\"a\":\"b\"}";
    }
    
}

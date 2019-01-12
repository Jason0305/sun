package com.lonton.petstore.controller;

import com.lonton.petstore.entity.ResponseJson;
import com.lonton.petstore.entity.User;
import com.lonton.petstore.services.IUserService;
import jdk.nashorn.internal.runtime.logging.DebugLogger;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器。
 *
 * @Author xuwanxing
 */
@Log4j
@RestController
@RequestMapping("/user")
public class UserController extends CenterController {
    
    @Autowired
    private IUserService userService;
    
    @RequestMapping(value = "/register.do", method = RequestMethod.GET)
    private ResponseJson registerAction(@RequestParam("username") String username,
                                        @RequestParam("password") String password,
                                        @RequestParam(value = "gender", required = false, defaultValue = "1") int gender,
                                        String phone, String email) {
//        userService.checkUsername(username);
//        userService.checkPassword(password);
//        userService.checkGender(gender);
        User user = userService.register(new User(username, password, gender, phone, email));
        return new ResponseJson<User>(user);
    }
    
    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    private ResponseJson loginAction(@RequestParam("username") String username,
                                     @RequestParam("password") String password) {
//        userService.checkUsername(username);
        log.info("username = " + username + ",password = " + password);
        
        return new ResponseJson<User>(userService.login(username, password));
    }
    
}

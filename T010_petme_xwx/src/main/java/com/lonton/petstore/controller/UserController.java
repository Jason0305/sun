package com.lonton.petstore.controller;

import com.lonton.petstore.entity.ResponseResult;
import com.lonton.petstore.entity.User;
import com.lonton.petstore.services.IUserService;
import com.lonton.petstore.services.exceptions.UploadAvatarException;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 用户控制器。
 *
 * @author xuwanxing
 */
@Log4j
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    
    /**
     * 用户业务层实例。
     */
    @Autowired
    private IUserService userService;
    
    /**
     * 注册页面。
     */
    @RequestMapping("/reg.do")
    private String register() {
        return "reg";
    }
    
    /**
     * 注册处理。
     *
     * @param username 用户名
     * @param password 密码
     * @param gender   性别
     * @param phone    电话
     * @param email    邮箱
     * @return json对象
     */
    @ResponseBody
    @RequestMapping(value = "/handle_reg.do", method = RequestMethod.GET)
    private ResponseResult<User> registerAction(@RequestParam("username") String username,
                                                @RequestParam("password") String password,
                                                @RequestParam(value = "gender", required = false, defaultValue = "1")
                                                        int gender,
                                                String phone, String email) {
        User user = userService.register(new User(username, password, gender, email, phone));
        return new ResponseResult<>(user);
    }
    
    /**
     * 用户名验证.
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
     * 登录页面响应
     *
     * @return 登录页面视图名
     */
    @RequestMapping("/login.do")
    private String loginPage() {
        log.warn("login.do....");
        return "login";
    }
    
    /**
     * 登录处理。
     *
     * @param username 用户名
     * @param password 密码
     * @param session  HttpSession
     * @return 响应数据
     */
    @ResponseBody
    @RequestMapping(value = "/handle_login.do", method = RequestMethod.GET)
    private ResponseResult<User> loginAction(@RequestParam("username") String username,
                                             @RequestParam("password") String password,
                                             HttpSession session) {
        log.info("username = " + username + ",password = " + password);
        User user = userService.login(username, password);
        // 将uid和username封装到Session中
        session.setAttribute("uid", user.getId());
        session.setAttribute("username", user.getUsername());
        return new ResponseResult<User>(user);
    }
    
    /**
     * 处理退出登录请求.
     *
     * @param session session
     */
    @ResponseBody
    @RequestMapping(value = "/login_out.do")
    private ResponseResult loginOutAction(HttpSession session) {
        session.removeAttribute("uid");
        session.removeAttribute("username");
        return new ResponseResult();
    }
    
    /**
     * 用户个人资料页面请求.
     *
     * @return 视图名
     */
    @RequestMapping(value = "/info.do", method = RequestMethod.GET)
    private String infoAction() {
        return "userInfo";
    }
    
    /**
     * 获取用户信息.
     *
     * @param session HttpSession
     * @return 响应数据
     */
    @ResponseBody
    @RequestMapping(value = "/get_info.do", method = RequestMethod.GET)
    private ResponseResult<User> getInfoAction(HttpSession session) {
        Integer uid = (Integer) session.getAttribute("uid");
        // 通过用户id获得用户数据
        User user = userService.getUserById(uid);
        // 保证密码安全将密码,盐值擦除后返回给前端
        user.setPassword(null);
        user.setSalt(null);
        return new ResponseResult<>(user);
    }
    
    
    /**
     * 更新用户信息.
     *
     * @param user    用户对象
     * @param session session
     * @return user对象
     */
    @ResponseBody
    @RequestMapping(value = "/update_info.do", method = RequestMethod.POST)
    private ResponseResult<User> updateInfoAction(User user, HttpServletRequest request,
                                                  @RequestParam(value = "avatarFile", required = false)
                                                          CommonsMultipartFile avatarFile,
                                                  HttpSession session) {
        if (avatarFile != null && !avatarFile.isEmpty()) {
            user.setAvatar(uploadAvatar(request, avatarFile));
        }
        if ("".equals(user.getPhone())) {
            user.setPhone(null);
        }
        if ("".equals(user.getUsername())) {
            user.setUsername(null);
        }
        if ("".equals(user.getEmail())) {
            user.setEmail(null);
        }
        Integer uid = (Integer) session.getAttribute("uid");
        user.setId(uid);
        
        userService.updateUserInfo(user);
        log.warn("user = " + user);
        return new ResponseResult<>(user);
    }
    
    /**
     * 处理图片路径及文件名.
     *
     * @param request    HttpServletRequest
     * @param avatarFile CommonsMultipartFile
     * @return 文件路径
     */
    private String uploadAvatar(HttpServletRequest request, CommonsMultipartFile avatarFile) {
        String uploadDirPath = request.getServletContext().getRealPath("upload");
        File uploadDir = new File(uploadDirPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        
        StringBuilder fileName = new StringBuilder(avatarFile.getOriginalFilename());
        log.warn("filename = " + fileName);
        log.warn("avatarFile.length = " + avatarFile.getSize());
        
        fileName.replace(0, fileName.lastIndexOf("."), UUID.randomUUID().toString());
        fileName.insert(0, new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss_").format(new Date()));
        File dest = new File(uploadDir, fileName.toString());
        log.error(dest.getAbsolutePath());
        //保存头像
        try {
            avatarFile.transferTo(dest);
        } catch (IllegalStateException e) {
            throw new UploadAvatarException("非法状态");
        } catch (IOException e) {
            throw new UploadAvatarException("读写出错");
        }
        return "upload/" + fileName;
    }
}

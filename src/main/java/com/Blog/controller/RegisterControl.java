package com.Blog.controller;

/*
 * 作者：赵国应
 * 时间：2019-1-8
 * 描述：注册时对密码加密
 */

import com.Blog.constant.Constants;
import com.Blog.model.User;
import com.Blog.service.UserService;
import com.Blog.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterControl {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    @ResponseBody
    public String register(User user, HttpServletRequest request){
        String authCode = request.getParameter("authCode");
        System.out.println(authCode);
        String trueMsgCode = (String) request.getSession().getAttribute("trueMsgCode");
        System.out.println(trueMsgCode);
        if(userService.usernameIsExit(user.getUsername())){
            return Constants.STATIC_THREE;
        }
        MD5Util md5Util = new MD5Util();
        user.setPassword(md5Util.encode(user.getPassword()));
        return userService.insert(user);
    }
}

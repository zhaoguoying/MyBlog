package com.Blog.controller;

/*
 * 作者：赵国应
 * 时间：2019-1-12
 * 描述：登陆控制
 */

import com.Blog.constant.Constants;
import com.Blog.model.User;
import com.Blog.service.UserService;
import com.Blog.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginControl {

    @Autowired
    UserService userService;

    @ResponseBody
    @PostMapping("/changePassword")
    public String changePassword(@RequestParam("phone") String phone,
                                 @RequestParam("authCode") String authCode,
                                 @RequestParam("newPassword") String newPassword,
                                 HttpServletRequest request) {
        String trueMsgCode = (String) request.getSession().getAttribute("trueMsgCode");
        //System.out.println(trueMsgCode);
        if (!authCode.equals(trueMsgCode)) {
            return Constants.STATIC_NONE;
        }
        User user = userService.findUserByPhone(phone);
        if (user == null) {
            return Constants.STATIC_TWO;
        }
        MD5Util md5Util = new MD5Util();
        String md5Password = md5Util.encode(newPassword);
        userService.updatePasswordByPhone(phone,md5Password);

        return Constants.STATIC_ONE;
    }
}

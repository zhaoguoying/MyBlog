package com.Blog.controller;

/*
 * 作者：赵国应
 * 时间：2019-1-7
 * 描述：user表接口具体业务逻辑
 */

import com.Blog.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@SuppressWarnings("all")
public class UserControl {

    @Autowired
    UserService userService;

    /**
     * 获得头像
     */
    @GetMapping("/getHeadPortraitUrl")
    public JSONObject getHeadPortraitUrl(@AuthenticationPrincipal Principal principal){
        String username = principal.getName();
        return userService.getHeadPortraitUrl(userService.findIdByUsername(username));
    }


}

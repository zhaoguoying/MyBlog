package com.Blog.controller;

/*
 * 作者：赵国应
 * 时间：2019-1-11
 * 描述：错误页面跳转
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorPageControl {

    @GetMapping("/404")
    public String error404(HttpServletRequest request, Model model){
        String username = (String)request.getSession().getAttribute("username");


        return "404";
    }
}

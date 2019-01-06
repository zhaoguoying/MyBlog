package com.Blog.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

/*
 * 作者：赵国应
 * 时间：2019-1-6
 * 描述：页面调转
 */
@Controller
public class BackControl {

    /*
     * 返回的是一个页面
     */
    @GetMapping("/")
    public String index(HttpServletRequest request, HttpServletResponse response,
                        @AuthenticationPrincipal Principal principal){
        String username = null;
        try {
            username = principal.getName();
        }catch (NullPointerException e){
            request.getSession().removeAttribute("lastUrl");
            return "index";
        }
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("lastUrl",(String)request.getSession().getAttribute("lastUrl"));
        return "index";
    }

    @GetMapping("/mylove")
    public String myLove(){
        return "mylove";
    }

    @GetMapping("/mystory")
    public String mystory(HttpServletRequest request){
        request.getSession().removeAttribute("lastUrl");
        return "mystory";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/tologin")
    public @ResponseBody void tologin(HttpServletRequest request){
        /*
         * 保存调转页面的URL
         */
        request.getSession().setAttribute("lastUrl",request.getHeader("Referer"));
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @GetMapping("/aboutme")
    public String aboutme(HttpServletRequest request){
        request.getSession().removeAttribute("lastUrl");
        return "aboutme";
    }

    @GetMapping("/update")
    public String update(HttpServletRequest request){
        request.getSession().removeAttribute("lastUrl");
        return "update";
    }

    @GetMapping("/friendlylink")
    public String friendlylink(HttpServletRequest request){
        request.getSession().removeAttribute("lastUrl");
        return "friendlylink";
    }

    @GetMapping("/ali")
    public String ali(){
        return "ali";
    }

    @GetMapping("/user")
    public String user(HttpServletRequest request){
        request.getSession().removeAttribute("lastUrl");
        return "user";
    }

    @GetMapping("/editor")
    public String editor(HttpServletRequest request){
        request.getSession().removeAttribute("lastUrl");
        String id = request.getParameter("id");
        if(!id.equals("")){
            request.getSession().setAttribute("id",id);
        }
        return "editor";
    }

    @GetMapping("/archives")
    public String archives(HttpServletRequest request,HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.getSession().removeAttribute("archives");
        String archives = request.getParameter("archives");

        return "archives";
    }

    @GetMapping("/superadmin")
    public String superadmin(HttpServletRequest request){
        request.getSession().removeAttribute("lastUrl");
        return "superadmin";
    }
}

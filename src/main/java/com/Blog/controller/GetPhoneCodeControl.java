package com.Blog.controller;

/*
 * 作者：赵国应
 * 时间：2019-1-9
 * 描述：获得手机验证码
 */

import com.Blog.constant.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GetPhoneCodeControl {

    @PostMapping("/getCode")
    @ResponseBody
    public int getAuthCode(HttpServletRequest request){
        String phone = request.getParameter("phone");
        String sign = request.getParameter("sign");
        /*
         * 正常使用
         */
        //String trueMsgCode = PhoneRandomBuilder.randomBuilder();
        /*
         * 开发使用
         */
        String trueMsgCode = "1111";
        request.getSession().setAttribute("trueMsgCode",trueMsgCode);

        return 1;
    }
}

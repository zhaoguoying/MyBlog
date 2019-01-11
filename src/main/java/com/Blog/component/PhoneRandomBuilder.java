package com.Blog.component;

/*
 * 作者：赵国应
 * 时间：2019-1-9
 * 描述：手机验证码
 */

import org.springframework.stereotype.Component;

/*
 * @Component把普通pojo实例化到spring容器中，相当于配置文件中的 <bean id="" class=""/>
 */
@Component
public class PhoneRandomBuilder {

    public static String randomBuilder() {
        String result = "";

        for (int i = 0; i < 4; i++) {
            result += Math.round(Math.random()*9);
        }
        return result;
    }

/*    public static void main(String[] args) {
        System.out.println(randomBuilder());
    }*/

}

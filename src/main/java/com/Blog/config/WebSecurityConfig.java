package com.Blog.config;

/*
 * 作者：赵国应
 * 时间：2019-1-10
 * 描述：SpringSecurity配置
 */

import com.Blog.service.security.CustomUserServiceImpl;
import com.Blog.utils.MD5Util;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    UserDetailsService customUserService() {
        return new CustomUserServiceImpl();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authentication) throws Exception {
        authentication.userDetailsService(customUserService()).passwordEncoder(new PasswordEncoder() {
            MD5Util md5Util = new MD5Util();
            @Override
            public String encode(CharSequence password) {
                    return md5Util.encode((String) password);
            }

            @Override
            public boolean matches(CharSequence password, String encodePassword) {
                return encodePassword.equals(md5Util.encode((String)password));
            }
        });
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeRequests()
                .antMatchers("/","/index","/aboutme","/archives","/categories","/friendlylink","/tags","/update")
                .permitAll()
                .antMatchers("/mylove","/editor","/user").hasAnyRole("USER")
                .antMatchers("/ali").hasAnyRole("ADMIN")
                .antMatchers("/superadmin").hasAnyRole("SUPERADMIN")
                .and()
                .formLogin().loginPage("/login").failureUrl("/login?error").defaultSuccessUrl("/")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/");

        httpSecurity.csrf().disable();
    }
}
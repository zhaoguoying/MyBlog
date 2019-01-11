package com.Blog.service.security;

import com.Blog.model.Role;
import com.Blog.model.User;
import com.Blog.repository.mybatis.UserRepository;
import com.Blog.service.UserService;
import com.Blog.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
 * 作者：赵国应
 * 时间：2019-1-10
 * 描述：用户登录处理
 */

@Service
public class CustomUserServiceImpl implements UserDetailsService {

    /*
     * 能够通过手机号查找用户
     */
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {

        User user = userRepository.findByPhone(phone);

        if(user ==null){
            throw new UsernameNotFoundException("用户不存在！");
        }

        TimeUtil timeUtil = new TimeUtil();
        /*
         * 最后登录时间 “年-月-日 时:分:秒”
         */
        String recentlyLanded = timeUtil.getFormatDateForSix();
        userService.updateRecentlyLanded(user.getUsername(),recentlyLanded);
        List<SimpleGrantedAuthority> authorities =new ArrayList<>();

        for (Role role : user.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }

}

package com.Blog.repository.mybatis;
/*
 * 作者：赵国应
 * 时间：2019-1-9
 * 描述：
 */

import com.Blog.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    /*
     * 通过手机号查找用户
     */
    User findByPhone(String phone);
}

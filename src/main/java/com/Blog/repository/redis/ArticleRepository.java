package com.Blog.repository.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
/*
 * 作者：赵国应
 * 时间：2019-1-16
 * 描述：
 */
@Repository
public class ArticleRepository {

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @SuppressWarnings("all")
    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valueOps;

}

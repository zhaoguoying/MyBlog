package com.Blog.controller;

/*
 * 作者：赵国应
 * 时间：2019-1-13
 * 描述：
 */

import com.Blog.service.ArticleService;
import com.Blog.service.CategoryService;
import com.Blog.service.TagService;
import com.Blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class EditorControl {

    private Logger logger = LoggerFactory.getLogger(EditorControl.class);

    @Autowired
    ArticleService articleService;

    @Autowired
    UserService userService;

    @Autowired
    TagService tagService;

    @Autowired
    CategoryService categoryService;



}

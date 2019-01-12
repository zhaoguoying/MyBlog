package com.Blog.model;

/*
 * 作者：赵国应
 * 时间：2019-1-13
 * 描述：访客
 */

import lombok.Data;

@Data
public class Visitor {

    private int id;
    /**
     * 访客人数
     */
    private long visitorNum;

    /**
     * 当前页的name or 文章名
     */
    private String pageName;


}

package com.Blog.model;

import lombok.Data;

/*
 * 作者：赵国应
 * 时间：2019-1-13
 * 描述：文章归档
 */

@Data
public class Archive {

    private int id;

    /**
     * 归档日期
     */
    private String archiveName;

}

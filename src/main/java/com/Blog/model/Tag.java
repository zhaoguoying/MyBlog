package com.Blog.model;

import lombok.Data;

/*
 * 作者：赵国应
 * 时间：2019-1-12
 * 描述：标签
 */
@Data
public class Tag {

    private int id;

    /**
     * 标签名
     */
    private String tagName;

    /**
     * 标签大小
     */
    private int tagSize;

    Tag() { }

    /*
     * public 不然后续不好使用
     */
    public Tag(String tagName, int tagSize) {
        this.tagName = tagName;
        this.tagSize = tagSize;
    }
}

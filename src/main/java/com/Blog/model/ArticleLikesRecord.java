package com.Blog.model;
/*
 * 作者：赵国应
 * 时间：2019-1-13
 * 描述：文章点赞记录
 */

import lombok.Data;

@Data
public class ArticleLikesRecord {

    private long id;

    /**
     * 文章id
     */
    private long articleId;

    /**
     * 原作者
     */
    private String originalAuthor;

    /**
     * 点赞人
     */
    private int likerId;

    /**
     * 点赞时间
     */
    private String likeDate;

    public ArticleLikesRecord() {
    }

    public ArticleLikesRecord(long articleId, String originalAuthor, int likerId, String likeDate) {
        this.articleId = articleId;
        this.originalAuthor = originalAuthor;
        this.likerId = likerId;
        this.likeDate = likeDate;
    }
}


package com.Blog.model;

/*
 * 作者：赵国应
 * 时间：2019-1-13
 * 描述：文章评论
 */

import lombok.Data;

@Data
public class Comment {

    private long id;

    /**
     * 留言的文章id
     */
    private long articleId;

    /**
     * 留言的文章的原作者
     */
    private String originalAuthor;

    /**
     * 回复的父id 若是评论则为 0，则是评论中的回复则为对应评论的id
     */
    private long pId=0;

    /**
     * 评论者
     */
    private int answererId;

    /**
     * 被回复者
     */
    private int respondentId;

    /**
     * 评论日期
     */
    private String commentDate;

    /**
     * 喜欢数
     */
    private int likes=0;

    /**
     * 评论内容
     */
    private String commentContent;


}

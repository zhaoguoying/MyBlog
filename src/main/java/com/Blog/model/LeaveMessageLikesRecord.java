package com.Blog.model;

/*
 * 作者：赵国应
 * 时间：2019-1-13
 * 描述：留言点赞
 */

import lombok.Data;

@Data
public class LeaveMessageLikesRecord {

    private long id;

    /**
     * 文章页
     */
    private String pageName;

    /**
     * 评论的id
     */
    private int pId;

    /**
     * 点赞人
     */
    private int likerId;

    /**
     * 点赞时间
     */
    private String likeDate;

    public LeaveMessageLikesRecord() {
    }

    public LeaveMessageLikesRecord(String pageName, int pId, int likerId, String likeDate) {
        this.pageName = pageName;
        this.pId = pId;
        this.likerId = likerId;
        this.likeDate = likeDate;
    }
}

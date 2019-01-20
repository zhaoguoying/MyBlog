package com.Blog.model;


import lombok.Data;

/*
 * 作者：赵国应
 * 时间：2019-1-13
 * 描述：反馈
 */

@Data
public class FeedBack {

    private int id;

    /**
     * 反馈内容
     */
    private String feedbackContent;

    /**
     * 联系方式
     */
    private String contactInfo;

    /**
     * 反馈人
     */
    private int personId;

    /**
     * 反馈时间
     */
    private String feedbackDate;

}


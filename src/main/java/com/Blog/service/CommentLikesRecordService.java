package com.Blog.service;


import com.Blog.model.CommentLikesRecord;
import org.springframework.stereotype.Service;

/*
 * 作者：赵国应
 * 时间：2019-1-13
 * 描述：文章评论点赞记录
 */

@Service
public interface CommentLikesRecordService {

    /**
     * 评论是否点赞
     * @return true -- 已经点过赞  false -- 还没有点过赞
     */
    boolean isLiked(long articleId, String originalAuthor, long pId, String username);

    /**
     * 保存评论中点赞的记录
     * @param commentLikesRecord
     */
    void insertCommentLikesRecord(CommentLikesRecord commentLikesRecord);

    /**
     * 通过文章id删除该文章的所有点赞记录
     * @param articleId 文章id
     */
    void deleteCommentLikesRecordByArticleId(long articleId);
}

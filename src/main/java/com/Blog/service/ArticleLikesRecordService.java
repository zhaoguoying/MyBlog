package com.Blog.service;

/*
 * 作者：赵国应
 * 时间：2019-1-13
 * 描述：文章点赞记录
 */

import com.Blog.model.ArticleLikesRecord;
import org.springframework.stereotype.Service;

@Service
public interface ArticleLikesRecordService {

    /**
     * 文章是否已经点过赞
     * @param articledId 文章id
     * @param originalAuthor 原作者
     * @param username 点赞人
     * @return true--已经点过赞  false--没有点赞
     */
    boolean isLiked(long articleId, String originalAuthor, String username);

    /**
     * 保存文章中点赞的记录
     * @param articleLikesRecord
     */
    void insertArticleLikesRecord(ArticleLikesRecord articleLikesRecord);

    /**
     * 通过文章id删除文章点赞记录
     * @param articleId 文章id
     */
    void deleteArticleLikesRecordByArticleId(long articleId);
}

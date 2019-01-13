package com.Blog.service.impl;

/*
 * 作者：赵国应
 * 时间：2019-1-13
 * 描述：文章点赞记录
 */

import com.Blog.mapper.ArticleLikesMapper;
import com.Blog.model.ArticleLikesRecord;
import com.Blog.service.ArticleLikesRecordService;
import com.Blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleLikesRecordServiceImpl implements ArticleLikesRecordService {

    @Autowired
    ArticleLikesMapper articleLikesMapper;
    @Autowired
    UserService userService;

    @Override
    public boolean isLiked(long articleId, String originalAuthor, String username) {
        ArticleLikesRecord articleLikesRecord = articleLikesMapper.isLiked(articleId, originalAuthor, userService.findIdByUsername(username));

        return articleLikesRecord != null;
    }

    @Override
    public void insertArticleLikesRecord(ArticleLikesRecord articleLikesRecord) {
        articleLikesMapper.insertArticleLikesRecord(articleLikesRecord);
    }

    @Override
    public void deleteArticleLikesRecordByArticleId(long articleId) {
        articleLikesMapper.deleteArticleLikesRecordByArticleId(articleId);
    }

}

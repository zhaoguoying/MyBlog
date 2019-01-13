package com.Blog.service.impl;

/*
 * 作者：赵国应
 * 时间：2019-1-13
 * 描述：文章评论点赞记录
 */

import com.Blog.mapper.CommentLikesMapper;
import com.Blog.model.CommentLikesRecord;
import com.Blog.service.CommentLikesRecordService;
import com.Blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentLikesRecordServiceImpl implements CommentLikesRecordService {

    @Autowired
    CommentLikesMapper commentLikesMapper;
    @Autowired
    UserService userService;

    @Override
    public boolean isLiked(long articleId, String originalAuthor, long pId, String username) {
        return commentLikesMapper.isLiked(articleId, originalAuthor, pId, userService.findIdByUsername(username)) != null;
    }

    @Override
    public void insertCommentLikesRecord(CommentLikesRecord commentLikesRecord) {
        commentLikesMapper.insertCommentLikesRecord(commentLikesRecord);
    }

    @Override
    public void deleteCommentLikesRecordByArticleId(long articleId) {
        commentLikesMapper.deleteCommentLikesRecordByArticleId(articleId);
    }
}


package com.Blog.service.impl;

/*
 * 作者：赵国应
 * 时间：2019-1-13
 * 描述：留言点赞
 */

import com.Blog.mapper.LeaveMessageLikesRecordMapper;
import com.Blog.model.LeaveMessageLikesRecord;
import com.Blog.service.LeaveMessageLikesRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveMessageLikesRecordServiceImpl implements LeaveMessageLikesRecordService {

    @Autowired
    LeaveMessageLikesRecordMapper leaveMessageLikesRecordMapper;

    @Override
    public boolean isLiked(String pageName, int pId, int likeId) {
        return leaveMessageLikesRecordMapper.isLiked(pageName,pId,likeId) != null;
    }

    @Override
    public void insertLeaveMessageLikesRecord(LeaveMessageLikesRecord leaveMessageLikesRecord) {
        leaveMessageLikesRecordMapper.insertLeaveMessageLikesRecord(leaveMessageLikesRecord);
    }
}

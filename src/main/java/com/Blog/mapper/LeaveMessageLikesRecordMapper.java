package com.Blog.mapper;

import com.Blog.model.LeaveMessageLikesRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/*
 * 作者：赵国应
 * 时间：2019-1-13
 * 描述：留言点赞
 */
@Mapper
@Repository
public interface LeaveMessageLikesRecordMapper {

    @Select("select likeDate from leave_message_likes_record where pageName=#{pageName} and pId=#{pId} and likerId=#{likerId}")
    LeaveMessageLikesRecord isLiked(@Param("pageName") String pageName, @Param("pId") int pId, @Param("likerId") int likerId);

    @Insert("insert into leave_message_likes_record(pageName,pId,likerId,likeDate) " +
            "values(#{pageName},#{pId},#{likerId},#{likeDate})")
    void insertLeaveMessageLikesRecord(LeaveMessageLikesRecord leaveMessageLikesRecord);
}

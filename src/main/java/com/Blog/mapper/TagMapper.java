package com.Blog.mapper;

import com.Blog.model.Tag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * 作者：赵国应
 * 时间：2019-1-12
 * 描述：标签
 */
@Mapper
@Repository
public interface TagMapper {

    @Insert("insert into tags(tagName,tagSize) values(#{tagName},#{tagSize})")
    void insertTag(Tag tag);

    /*
     * IFNULL(expression_1,expression_2) expression_1不是NULL返回expression_1，如果是返回expression_2
     */
    @Select("select IFNULL(max(id),0) from tags where tagName=#{tagName}")
    int findIsExitByTagName(@Param("tagName") String tagName);

    @Select("select * from tags order by id desc")
    List<Tag> findTagsCloud();

    @Select("select count(*) from tags")
    int countTagsNum();

    @Select("select tagSize from tags where tagName=#{tagName}")
    int getTagsSizeByTagName(String tagName);

}

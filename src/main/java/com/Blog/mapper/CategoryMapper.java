package com.Blog.mapper;

/*
 * 作者：赵国应
 * 时间：2019-1-12
 * 描述：文章分类
 */

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CategoryMapper {

    @Select("select categoryName from categories")
    List<String> findCategoriesName();

    @Select("select count(*) from categories")
    int countCategoriesNum();
}

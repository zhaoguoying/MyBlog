package com.Blog.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArchiveMapper {

    @Select("select archiveName from archives order by id desc")
    List<String> findArchives();

    @Insert("insert into archives(archiveName) values(#{archiveName})")
    void addArchiveName(@Param("archiveName") String archiveName);

    @Select("select IFNULL(max(id),0) from archives where archiveName=#{archiveName}")
    int findArchiveNameByArchiveName(@Param("archiveName") String archiveName);

}

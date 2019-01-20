package com.Blog.service;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

/*
 * 作者：赵国应
 * 时间：2019-1-14
 * 描述：归档
 */
@Service
public interface ArchiveService {
    /**
     * 获得归档信息
     * @return
     */
    JSONObject findArchiveNameAndArticleNum();

    /**
     * 添加归档日期
     * @param archiveName
     */
    void addArchiveName(String archiveName);
}

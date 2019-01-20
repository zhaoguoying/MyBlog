package com.Blog.service;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 * 作者：赵国应
 * 时间：2019-1-15
 * 描述：悄悄话
 */
@Service
public interface PrivateWordService {

    /**
     * 发布悄悄话
     * @param privateWordContent 悄悄话
     * @return
     */
    @Transactional
    JSONObject publishPrivateWord(String privateWordContent, String username);

    /**
     * 获得悄悄话内容
     * @param publisher
     * @return
     */
    JSONObject getPrivateWordByPublisher(String publisher, int rows, int pageNum);

    /**
     * 获得所有悄悄内容
     * @return
     */
    JSONObject getAllPrivateWord();

    /**
     * 回复悄悄话
     * @param replyContent 回复内容
     * @param username 回复人
     * @return
     */
    @Transactional
    JSONObject replyPrivateWord(String replyContent, String username, int id);
}

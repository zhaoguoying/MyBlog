package com.Blog.service;

/*
 * 作者：赵国应
 * 时间：2019-1-15
 * 描述：反馈sql
 */

import com.Blog.model.FeedBack;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface FeedBackService {

    /**
     * 保存反馈信息
     * @param feedBack
     * @return
     */
    @Transactional
    JSONObject submitFeedback(FeedBack feedBack);

    /**
     * 获得所有的反馈
     * @return
     */
    JSONObject getAllFeedback(int rows, int pageNum);

}

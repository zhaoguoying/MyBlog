package com.Blog.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

/*
 * 作者：赵国应
 * 时间：2019-1-12
 * 描述：分类操作
 */
@Service
public interface CategoryService {

    /**
     * 获得所有的分类以及该分类的文章总数
     * @return
     */
    JSONObject findCategoriesNameAndArticleNum();

    /**
     * 获得所有的分类
     * @return
     */
    JSONArray findCategoriesName();

    /**
     * 获得分类数目
     * @return
     */
    int countCategoriesNum();

}

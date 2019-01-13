package com.Blog.service.impl;

import com.Blog.component.StringAndArray;
import com.Blog.mapper.ArticleMapper;
import com.Blog.model.Article;
import com.Blog.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;
    @Override
    public JSONObject insertArticle(Article article) {
        return null;
    }

    @Override
    public JSONObject updateArticleById(Article article) {
        return null;
    }

    @Override
    public JSONObject getArticleByArticleIdAndOriginalAuthor(long articleId, String originalAuthor, String username) {
        return null;
    }

    @Override
    public Map<String, String> findArticleTitleByArticleIdAndOriginalAuthor(long articleId, String originalAuthor) {
        return null;
    }

    @Override
    public JSONArray findAllArticles(String rows, String pageNo) {
        return null;
    }

    @Override
    public void updateArticleLastOrNextId(String lastOrNext, long lastOrNextArticleId, long articleId) {

    }

    @Override
    public int updateLikeByArticleIdAndOriginalAuthor(long articleId, String originalAuthor) {
        return 0;
    }

    @Override
    public JSONObject findArticleByTag(String tag, int rows, int pageNum) {
        PageHelper.startPage(pageNum,rows);
        List<Article> articles = articleMapper.findArticleByTag(tag);
        PageInfo<Article> pageInfo = new PageInfo<>(articles);
        JSONObject articleJson;
        JSONArray articleJsonArray = new JSONArray();

        for (Article article : articles){
            String[] tagsArray = StringAndArray.stringToArray(article.getArticleTags());
            for (String str : tagsArray){
                if (str.equals(tag)) {
                    articleJson = new JSONObject();
                    articleJson.put("articleId", article.getArticleId());
                    articleJson.put("originalAuthor", article.getOriginalAuthor());
                    articleJson.put("articleTitle", article.getArticleTitle());
                    articleJson.put("articleCategories", article.getArticleCategories());
                    articleJson.put("publishDate", article.getPublishDate());
                    articleJson.put("articleTags", tagsArray);
                    articleJsonArray.add(articleJson);
                }
            }
        }
        JSONObject pageJson = new JSONObject();
        pageJson.put("pageNum",pageInfo.getPageNum());
        pageJson.put("pageSize",pageInfo.getPageSize());
        pageJson.put("total",pageInfo.getTotal());
        pageJson.put("pages",pageInfo.getPages());
        pageJson.put("isFirstPage",pageInfo.isIsFirstPage());
        pageJson.put("isLastPage",pageInfo.isIsLastPage());

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status",201);
        jsonObject.put("result",articleJsonArray);
        jsonObject.put("tag",tag);
        jsonObject.put("pageInfo",pageJson);
        return jsonObject;
    }

    @Override
    public JSONObject findArticleByCategory(String category, int rows, int pageNum) {
        return null;
    }

    @Override
    public JSONObject findArticleByArchive(String archive, int rows, int pageNum) {
        return null;
    }

    @Override
    public JSONObject getDraftArticle(Article article, String[] articleTags, int articleGrade) {
        return null;
    }

    @Override
    public JSONObject getArticleManagement(int rows, int pageNum) {
        return null;
    }

    @Override
    public Article findArticleById(int id) {
        return null;
    }

    @Override
    public int countArticleCategoryByCategory(String category) {
        return articleMapper.countArticleCategoryByCategory(category);
    }

    @Override
    public int countArticleArchiveByArchive(String archive) {
        return 0;
    }

    @Override
    public int countArticle() {
        return articleMapper.countArticle();
    }

    @Override
    public int deleteArticle(long id) {
        return 0;
    }
}


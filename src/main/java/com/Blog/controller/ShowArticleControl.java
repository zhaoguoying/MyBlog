package com.Blog.controller;

/*
 * 作者：赵国应
 * 时间：2019-1-13
 * 描述：文章显示页面
 */

import com.Blog.model.ArticleLikesRecord;
import com.Blog.service.ArticleLikesRecordService;
import com.Blog.service.ArticleService;
import com.Blog.service.UserService;
import com.Blog.utils.TimeUtil;
import com.Blog.utils.TransCodingUtil;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class ShowArticleControl {

    private Logger logger = LoggerFactory.getLogger(ShowArticleControl.class);

    @Autowired
    ArticleLikesRecordService articleLikesRecordService;
    @Autowired
    ArticleService articleService;
    @Autowired
    UserService userService;

    /**
     *  获取文章
     * @param articleId 文章id
     * @param originalAuthor 原作者
     * @return
     */
    @PostMapping("/getArticleByArticleIdAndOriginalAuthor")
    public @ResponseBody
    JSONObject getArticleByIdAndOriginalAuthor(@RequestParam("articleId") String articleId,
                                               @RequestParam("originalAuthor") String originalAuthor,
                                               @AuthenticationPrincipal Principal principal){
        String username = null;
        try {
            username = principal.getName();
        } catch (NullPointerException e){
            logger.info("This user is not login");
        }
        JSONObject jsonObject = articleService.getArticleByArticleIdAndOriginalAuthor(Long.parseLong(articleId), TransCodingUtil.unicodeToString(originalAuthor),username);
        return jsonObject;
    }

    /**
     * 点赞
     * @param articleId 文章号
     * @return
     */
    @GetMapping("/addArticleLike")
    public @ResponseBody int addArticleLike(@RequestParam("articleId") String articleId,
                                            @RequestParam("originalAuthor") String originalAuthor,
                                            @AuthenticationPrincipal Principal principal){

        String username="";
        try {
            username = principal.getName();
        }catch (NullPointerException e){
            logger.error("username " + username + " is not login");
            return -1;
        }

        String stringOriginalAuthor = TransCodingUtil.unicodeToString(originalAuthor);
        if(articleLikesRecordService.isLiked(Long.parseLong(articleId), stringOriginalAuthor, username)){
            logger.info("你已经点过赞了");
            return -2;
        }
        int likes = articleService.updateLikeByArticleIdAndOriginalAuthor(Long.parseLong(articleId), stringOriginalAuthor);
        ArticleLikesRecord articleLikesRecord = new ArticleLikesRecord(Long.parseLong(articleId), stringOriginalAuthor, userService.findIdByUsername(username), new TimeUtil().getFormatDateForFive());
        articleLikesRecordService.insertArticleLikesRecord(articleLikesRecord);
        logger.info("点赞成功");
        return likes;
    }

}


package com.Blog;

import com.Blog.mapper.*;
import com.Blog.model.Comment;
import com.Blog.repository.mybatis.UserRepository;
import com.Blog.service.ArticleService;
import com.Blog.service.UserService;
import com.Blog.service.impl.*;
import com.Blog.service.security.CustomUserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBlogApplicationTests {

	@Autowired
	UserMapper userMapper;

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	CustomUserServiceImpl customUserService;

	@Autowired
	VisitorMapper visitorMapper;

	@Autowired
	VisitorServiceImpl visitorService;

	@Autowired
	ArticleMapper articleMapper;

	@Autowired
	TagMapper tagMapper;

	@Autowired
	TagServiceImpl tagService;

	@Autowired
	CategoryMapper categoryMapper;

	@Autowired
    CategoryServiceImpl categoryServiceImpl;

	@Autowired
    ArticleService articleService;

	@Autowired
	ArticleServiceImpl articleServiceImpl;

	@Autowired
	CommentMapper commentMapper;

	@Autowired
	CommentServiceImpl commentServiceImpl;

	Comment comment = new Comment();

	@Test
	public void commentNum_test(){
		System.out.println(
				commentServiceImpl.commentNum());
	}

	@Test
	public void replyReplyReturn_test(){
		System.out.println(
				commentServiceImpl.replyReplyReturn(comment,"赵国应","赵国应"));
	}

	@Test
	public void findCommentByArticleIdAndOriginalAuthorfindReplyByArticleIdAndOriginalAuthorAndPid_test(){
		System.out.println(
				commentServiceImpl.findReplyByArticleIdAndOriginalAuthorAndPid(1533196734,"赵国应",2));
	}

	@Test
	public void findCommentByArticleIdAndOriginalAuthor_test(){
		System.out.println(
				commentServiceImpl.findCommentByArticleIdAndOriginalAuthor(1533196734,"赵国应","赵国应"));
	}

	@Test
	public void countReplyNumById_test(){
		System.out.println(commentMapper.countReplyNumById(0));
	}

	@Test
	public void findFiveNewComment_test(){
		System.out.println(commentMapper.findFiveNewComment());
	}

	@Test
	public void findArticleByTag_s_test(){
		System.out.println(articleService.findArticleByTag("随笔感悟",20,25));
	}

	@Test
	public void findArticleByTag_test(){
		System.out.println(articleServiceImpl.findArticleByTag("随笔感悟",10,5));
	}

    @Test
    public void countArticle_s_test(){
        System.out.println(articleService.countArticle());
    }

	@Test
    public void findCategoriesNameAndArticleNum_test(){
        System.out.println(categoryServiceImpl.findCategoriesNameAndArticleNum());
    }

	@Test
	public void findCategoriesName_test(){
		System.out.println(categoryMapper.findCategoriesName());
	}

	@Test
	public void contextLoads() {
		System.out.println("haaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}

	@Test
	public void findUserByPhone_test(){
		System.out.println(userMapper.findUserByPhone("1234567879"));
	}

	@Test
	public void getHeadPortraitUrl_Test(){
		System.out.println(userService.getHeadPortraitUrl(1));
	}

	@Test
	public void getUserPersonalInfoByUsername_Test(){
		System.out.println((userService.getUserPersonalInfoByUsername("赵国应")));
	}

	@Test
	public void findByPhone_test(){
		System.out.println(userRepository.findByPhone("1234567879"));
	}

	@Test
	public void loadUserByUsername_test(){
		System.out.println(customUserService.loadUserByUsername("1234567879"));
	}

	@Test
	public void getAllVisitor_Test(){
		System.out.println(visitorMapper.getAllVisitor());
	}

	@Test
	public void getVisitorNumByPageName_test(){
		System.out.println(visitorMapper.getVisitorNumByPageName("totalVisitor"));
	}

	@Test
	public void getVisitorNumByPageName_Test(){
		System.out.println(visitorService.getVisitorNumByPageName("visitorVolume"));
	}

	@Test
	public void getArticleUrlById_test(){
		System.out.println(articleMapper.getArticleUrlById(1));
	}

	@Test
	public void findAllArticlesPartInfo_test(){
		System.out.println(articleMapper.findAllArticlesPartInfo());
	}

	@Test
	public void countArticle_test(){
		System.out.println(articleMapper.countArticle());
	}

	@Test
	public void findAllArticleId_test(){
		System.out.println(articleMapper.findAllArticleId(1));
	}

	@Test
	public void findArticleByCategory_test(){
		System.out.println(articleMapper.findArticleByCategory("我的故事"));
	}

	@Test
	public void findTagsCloud_test(){
		System.out.println(tagMapper.findTagsCloud());
	}

	@Test
	public void findIsExitByTagName_test(){
		System.out.println(tagMapper.findIsExitByTagName("SpringBoot"));
	}

	@Test
	public void findTagsCloudImp_test(){
		System.out.println(tagService.findTagsCloud());
	}


}


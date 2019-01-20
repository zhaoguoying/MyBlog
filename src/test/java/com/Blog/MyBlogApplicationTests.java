package com.Blog;

import com.Blog.mapper.*;
import com.Blog.model.Comment;
import com.Blog.repository.mybatis.UserRepository;
import com.Blog.service.ArchiveService;
import com.Blog.service.ArticleService;
import com.Blog.service.UserService;
import com.Blog.service.impl.*;
import com.Blog.service.security.CustomUserServiceImpl;
import com.Blog.utils.MD5Util;
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
	UserServiceImpl userServiceImpl;

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

    @Autowired
    LeaveMessageServiceImpl leaveMessageServiceImpl;

	@Autowired
	LeaveMessageMapper leaveMessageMapper;

	@Autowired
    PrivateWordMapper privateWordMapper;

	@Autowired
	ArchiveService archiveService;

	@Test
	public void findArchiveNameAndArticleNum_test(){
		System.out.println(archiveService.findArchiveNameAndArticleNum());
	}


	@Test
    public void getPrivateWordByPublisher_test(){
        System.out.println(privateWordMapper.getPrivateWordByPublisher(1));
    }

	@Test
	public void getAllPrivateWord_test(){
		System.out.println(privateWordMapper.getAllPrivateWord());
	}

    @Test
    public void publishLeaveMessage_test(){
    	/*
    	 * 留言测试
    	 */
        leaveMessageServiceImpl.publishLeaveMessage("留言测试哈哈","1","赵国应");
    }

	@Test
	public void publishLeaveMessageReply_test(){
		System.out.println(leaveMessageMapper.findAllLeaveMessage("friendlylink",0));
	}

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

	@Test
	public void updataPassword_test(){
		MD5Util md5Util = new MD5Util();
		String md5Password = md5Util.encode("123456");
		userService.updatePasswordByPhone("15286221111",md5Password);
	}
	@Test
	public void updataPassword_impl_test(){
		userServiceImpl.updatePasswordByPhone("15286221111","111111111");
	}

}


package com.Blog.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/*
 * 作者：赵国应
 * 时间：2019-1-10
 * 描述：定制错误页面
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer container) {
                ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401");
                ErrorPage error403Page = new ErrorPage(HttpStatus.NOT_FOUND, "/403");
                ErrorPage error404Page = new ErrorPage(HttpStatus.FORBIDDEN, "/404");
                ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500");

                container.addErrorPages(error401Page, error403Page, error404Page, error500Page);
            }
        };
    }
}

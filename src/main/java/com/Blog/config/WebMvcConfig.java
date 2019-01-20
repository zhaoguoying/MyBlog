package com.Blog.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/*
 * 作者：赵国应
 * 时间：2019-1-10
 * 描述：定制错误页面
 */

@Configuration
public class WebMvcConfig implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer(){
        return (container -> {
            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401");
            ErrorPage error403Page = new ErrorPage(HttpStatus.NOT_FOUND, "/403");
            ErrorPage error404Page = new ErrorPage(HttpStatus.FORBIDDEN, "/404");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500");

            container.addErrorPages(error401Page, error403Page, error404Page, error500Page);
        });
    }

    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        factory.setPort(8080);
    }
}

/*
     * 一下方法在2.0版本之后就已经被废弃


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
*/


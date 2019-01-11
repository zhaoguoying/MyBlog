package com.Blog.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * 作者：赵国应
 * 时间：2019-1-9
 * 描述：基于JavaConfig配置MyBatis的配置文件方式写sql语句的扫描包
 */
@Configuration
public class MyBatisScannerConfig {

    @Bean
    public static MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.Blog.repository.mybatis");
        /*
         * 将SqlSessionFactory对象注入到sqlSessionFactory
         */
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");

        return mapperScannerConfigurer;
    }
}

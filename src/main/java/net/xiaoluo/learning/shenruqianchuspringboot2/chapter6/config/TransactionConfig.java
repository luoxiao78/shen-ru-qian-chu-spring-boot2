package net.xiaoluo.learning.shenruqianchuspringboot2.chapter6.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-17
 */
@Configuration
@ComponentScan("net.xiaoluo.learning.shenruqianchuspringboot2.chapter6")
@PropertySource("classpath:application.properties")
@MapperScan(basePackages = "net.xiaoluo.learning.shenruqianchuspringboot2.chapter6",
            sqlSessionFactoryRef = "sqlSessionFactory",
            annotationClass = Repository.class)
public class TransactionConfig {

}

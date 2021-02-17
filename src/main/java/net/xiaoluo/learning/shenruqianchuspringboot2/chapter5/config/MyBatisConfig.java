package net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-16
 */
@Configuration
@ComponentScan("net.xiaoluo.learning.shenruqianchuspringboot2.chapter5")
@PropertySource("classpath:application.properties")
public class MyBatisConfig {

  @Bean
  public MapperScannerConfigurer mapperScannerConfigurer() {
    final MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
    mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
    mapperScannerConfigurer.setBasePackage("net.xiaoluo.learning.shenruqianchuspringboot2.chapter5");
    mapperScannerConfigurer.setAnnotationClass(Repository.class);
    return mapperScannerConfigurer;
  }
}

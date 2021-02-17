package net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.config;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.dao.UserMyBatisDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-16
 */
@Configuration
@ComponentScan("net.xiaoluo.learning.shenruqianchuspringboot2.chapter5")
@PropertySource("classpath:application.properties")
public class MyBatisConfig {

  private final SqlSessionFactory sqlSessionFactory;

  public MyBatisConfig(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Bean
  public MapperFactoryBean<UserMyBatisDao> initUserMyBatisDao() {
    final MapperFactoryBean<UserMyBatisDao> userMyBatisDaoMapperFactoryBean = new MapperFactoryBean<>();
    userMyBatisDaoMapperFactoryBean.setMapperInterface(UserMyBatisDao.class);
    userMyBatisDaoMapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
    return userMyBatisDaoMapperFactoryBean;
  }
}

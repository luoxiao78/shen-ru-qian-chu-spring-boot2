package net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.config;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-09
 */
@Configuration
// @PropertySource("classpath:jdbc.properties")
@ComponentScan({"net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.*"})
public class AppConfig {

  @Bean(name = "dataSource")
  public DataSource getDataSource() {
    final Properties properties = new Properties();

    properties.setProperty("driver", "com.mysql.jdbc.Driver");
    properties.setProperty("url", "jdbc:mysql://localhost:3306/chapter3");
    properties.setProperty("username", "root");
    properties.setProperty("password", "123456");
    DataSource dataSource = null;
    try {
      dataSource = BasicDataSourceFactory.createDataSource(properties);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return dataSource;
  }
}

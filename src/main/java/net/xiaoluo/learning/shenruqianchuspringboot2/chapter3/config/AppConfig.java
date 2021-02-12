package net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.config;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.condition.DatabaseConditional;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-09
 */
@Configuration
@PropertySource("classpath:application.properties")
// @PropertySource("classpath:application-${spring.profiles.active}.properties")
@PropertySource("classpath:jdbc-${spring.profiles.active}.properties")
@ComponentScan({"net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.*"})
@ImportResource("classpath:spring-other.xml")
public class AppConfig {

  @Bean(name = "dataSource", destroyMethod = "close")
  // will generate this bean only if matching the conditions in DatabaseConditional
  @Conditional(DatabaseConditional.class)
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

  @Bean(name = "dataSource", destroyMethod = "close")
  // will generate this bean only if matching the conditions in DatabaseConditional
  @Conditional(DatabaseConditional.class)
  public DataSource getTestDataSource() {
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

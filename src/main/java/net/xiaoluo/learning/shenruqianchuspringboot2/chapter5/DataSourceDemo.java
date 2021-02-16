package net.xiaoluo.learning.shenruqianchuspringboot2.chapter5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-15
 */
@SpringBootApplication
public class DataSourceDemo {

  private static final Logger logger = LoggerFactory.getLogger(DataSourceDemo.class);

  public static void main(String[] args) {
    final ApplicationContext ctx = SpringApplication.run(DataSourceDemo.class, args);
    final DataSource dataSource = ctx.getBean(DataSource.class);
    logger.info(String.format("------------------%n%s%n-------------", dataSource.getClass().getName()));
  }

}

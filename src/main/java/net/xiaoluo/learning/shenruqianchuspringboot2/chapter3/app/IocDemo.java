package net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.app;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.config.AppConfig;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.model.*;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-09
 */
@SpringBootApplication
public class IocDemo {

  private static final Logger logger = LoggerFactory.getLogger(IocDemo.class);



  public static void main(String[] args) {
    // final ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    final ApplicationContext ctx = SpringApplication.run(AppConfig.class, args);
    final UserService userService = ctx.getBean(UserService.class);
    userService.userInfo(ctx.getBean(User.class));
    logger.info(ctx.getBean("dataSource").getClass().getName());
    logger.info(ctx.getBean(Animal.class).workInfo());
    ctx.getBean(DogOwner.class).service();
    ctx.getBean(CatOwner.class).service();
    logger.info(ctx.getEnvironment().getProperty("spring.profiles.active"));
    logger.info(ctx.getBean(DatabaseProperties.class).getUsername());
    logger.info(ctx.getBean(DatabaseProperties.class).getProfileDescription());
    logger.info(ctx.getBean(Squirrel.class).workInfo());
  }

}

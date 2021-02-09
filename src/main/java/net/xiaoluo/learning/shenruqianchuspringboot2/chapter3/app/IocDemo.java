package net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.app;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.config.AppConfig;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.model.Animal;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.model.Owner;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.model.User;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-09
 */
@SpringBootApplication
public class IocDemo {

  private static final Logger logger = LoggerFactory.getLogger(IocDemo.class);

  public static void main(String[] args) {
    final ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    final UserService userService = ctx.getBean(UserService.class);
    userService.userInfo(ctx.getBean(User.class));
    logger.info(ctx.getBean("dataSource").getClass().getName());
    logger.info(ctx.getBean(Animal.class).workInfo());
    ctx.getBean(Owner.class).service();
  }

}

package net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.app;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.config.AppConfig;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.config.User;
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
    final User user = ctx.getBean(User.class);
    logger.info(user.getUserName());
  }

}

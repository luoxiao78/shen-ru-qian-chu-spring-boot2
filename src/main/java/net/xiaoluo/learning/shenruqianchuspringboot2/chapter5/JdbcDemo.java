package net.xiaoluo.learning.shenruqianchuspringboot2.chapter5;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.model.Sex;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.model.User;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.service.UserServiceJdbcTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-15
 */
@SpringBootApplication
public class JdbcDemo {

  private static final Logger logger = LoggerFactory.getLogger(JdbcDemo.class);

  public static void main(String[] args) {
    final ApplicationContext ctx = SpringApplication.run(JdbcDemo.class, args);
    final UserServiceJdbcTemplate userService = ctx.getBean(UserServiceJdbcTemplate.class);
    final User user = new User();
    user.setUserName("user1");
    user.setNote("note1");
    user.setSex(Sex.MALE);
    // logger.info(String.format("添加了%d个用户", userService.insertUser(user)));
    logger.info(userService.getUser(1L).getUserName());
    userService.findAll("user1", "note1").forEach((item) -> System.out.println(item.getNote()));
    final User savedUser = userService.getUser(1L);
    savedUser.setSex(Sex.FEMALE);
    logger.info("改变性别");
    logger.info(String.format("改变了%d个用户数据", userService.updateUser(savedUser)));
    logger.info("第一个用户的性别为" + userService.getUser(1L).getSex());
    // logger.info(String.format("删除了%d个用户" + userService.deleteUser(1L)));
  }
}

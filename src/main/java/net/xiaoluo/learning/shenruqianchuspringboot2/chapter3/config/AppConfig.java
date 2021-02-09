package net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.config;

import net.xiaoluo.learning.shenruqianchuspringboot2.common.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-09
 */
@Configuration
public class AppConfig {

  @Bean(name = "user")
  public User initUser() {
    final User user = new User();
    user.setId(1L);
    user.setUserName("user_1");
    user.setNote("note_1");
    return user;
  }
}

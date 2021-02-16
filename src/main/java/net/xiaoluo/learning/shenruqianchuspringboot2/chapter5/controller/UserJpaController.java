package net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.controller;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.model.User;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-16
 */
@RestController
public class UserJpaController {

  private UserService userService;

  public UserJpaController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping("/user/{id}")
  public User getUser(@PathVariable Long id) {
    return userService.getUser(id);
  }

}

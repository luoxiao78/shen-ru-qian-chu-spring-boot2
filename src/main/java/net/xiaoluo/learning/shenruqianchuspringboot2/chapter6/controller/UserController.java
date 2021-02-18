package net.xiaoluo.learning.shenruqianchuspringboot2.chapter6.controller;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.model.Sex;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.model.User;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter6.service.UserBatchService;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter6.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-17
 */
@RestController
@RequestMapping("/chapter6")
public class UserController {

  private UserService userService;
  private UserBatchService userBatchService;

  public UserController(UserService userService, UserBatchService userBatchService) {
    this.userService = userService;
    this.userBatchService = userBatchService;
  }

  @RequestMapping("/user/{id}")
  public User getUser(@PathVariable Long id) {
    return userService.getUser(id);
  }

  @RequestMapping("insertUser")
  public Map<String, Object> insertUser(String userName, String note) {
    final User user = new User();
    user.setUserName(userName);
    user.setNote(note);

    final int update = userService.insertUser(user);
    Map<String, Object> result = new HashMap<>();
    result.put("success", update == 1);
    result.put("user", user);
    return result;
  }

  @RequestMapping("/updateuser")
  public Map<String, Object> updateUser(Long id, String userName, Integer sexId, String note) {
    final User user = new User();
    user.setId(id);
    user.setUserName(userName);
    user.setSex(Sex.getSexById(sexId));
    user.setNote(note);

    final int update = userService.updateUser(user);
    final Map<String, Object> result = new HashMap<>();
    result.put("success", update == 1);
    result.put("user", user);
    return result;
  }

  @RequestMapping("insertUsers")
  public Map<String, Object> insertUsers(String userName1,
                                         String note1,
                                         String userName2,
                                         String note2) {
    final User user1 = new User();
    user1.setUserName(userName1);
    user1.setNote(note1);
    final User user2 = new User();
    user2.setUserName(userName2);
    user2.setNote(note2);

    List<User> users = new ArrayList<>();
    users.add(user1);
    users.add(user2);

    int inserts = userBatchService.insertUsers(users);
    final Map<String, Object> result = new HashMap<>();
    result.put("success", inserts == 2);
    result.put("user", users);

    return result;
  }

}

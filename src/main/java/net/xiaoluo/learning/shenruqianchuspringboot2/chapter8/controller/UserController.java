package net.xiaoluo.learning.shenruqianchuspringboot2.chapter8.controller;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter8.model.User;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter8.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-03-03
 */
@Controller
@RequestMapping("/user")
public class UserController {

  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping("/page")
  public String page() {
    return "user";
  }

  @RequestMapping("/save")
  @ResponseBody
  public User saveUser(@RequestBody User user) { // why use annotation on parameter
    userService.saveUser(user);
    return user;
  }

  @RequestMapping("/get")
  @ResponseBody
  public User getUser(Long id) {
    return userService.getUser(id);
  }

  @RequestMapping("/find")
  @ResponseBody
  public List<User> findUser(String userName, String note, int skip, int limit) {
    return userService.findUser(userName, note, skip, limit);
  }

  @RequestMapping("/update")
  @ResponseBody
  public UpdateResult updateUser(Long id, String userName, String note) {
    return userService.updateUser(id, userName, note);
  }

  @RequestMapping("/delete")
  @ResponseBody
  public DeleteResult deleteUser(Long id) {
    return userService.deleteUser(id);
  }

}

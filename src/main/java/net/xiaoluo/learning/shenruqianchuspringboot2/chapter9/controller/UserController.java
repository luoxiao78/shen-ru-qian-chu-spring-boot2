package net.xiaoluo.learning.shenruqianchuspringboot2.chapter9.controller;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter9.model.User;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter9.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-03-08
 */
@Controller
@RequestMapping("/user")
public class UserController {

  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/list")
  @ResponseBody
  public List<User> list() {
    return userService.getAll();
  }

  @GetMapping("/{id}")
  @ResponseBody
  public User getUser(@PathVariable String id) {
    return userService.getUser(id).orElse(null);
  }

  @GetMapping("/newUser/userName={userName}&note={note}")
  @ResponseBody
  public User saveUser(@PathVariable String userName,
                       @PathVariable String note) {
    final User user = new User();
    user.setUserName(userName);
    user.setNote(note);
    final User savedUser = userService.saveOrUpdateUser(user);
    return savedUser;
  }

  @GetMapping("/update/userId={id}&userName={userName}&note={note}")
  @ResponseBody
  public User updateUser(@PathVariable String id,
                         @PathVariable String userName,
                         @PathVariable String note) {
    final Optional<User> existedUserOpt = userService.getUser(id);
    existedUserOpt.ifPresent((user -> {
      user.setUserName(userName);
      user.setNote(note);
      userService.saveOrUpdateUser(user);
    }));
    return userService.getUser(id).orElse(null);
  }

  @GetMapping("/findUser/userName={userName}&note={note}")
  @ResponseBody
  public User findUser(@PathVariable String userName,
                       @PathVariable String note) {
    return userService.findUser(userName, note).orElse(null);
  }

  @GetMapping("/deleteUser/userName={userName}&note={note}")
  @ResponseBody
  public User deleteUser(@PathVariable String userName,
                         @PathVariable String note) {
    final Optional<User> existedUserOpt = userService.findUser(userName, note);
    existedUserOpt.ifPresent(user -> userService.deleteUser(user));
    return existedUserOpt.orElse(null);
  }

}

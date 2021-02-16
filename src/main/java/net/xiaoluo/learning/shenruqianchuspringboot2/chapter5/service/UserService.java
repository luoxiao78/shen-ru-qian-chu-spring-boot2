package net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.service;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.model.Sex;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.model.User;

import java.util.List;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-16
 */
public interface UserService {

  User getUser(Long id);

  List<User> findByNameAndSex(String userName, Sex sex);

  int insertUser(User user);

  int deleteUser(Long id);

  int updateUser(User user);

}

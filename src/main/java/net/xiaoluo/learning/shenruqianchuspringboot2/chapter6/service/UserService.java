package net.xiaoluo.learning.shenruqianchuspringboot2.chapter6.service;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.model.User;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-17
 */
public interface UserService {

  User getUser(Long id);

  int insertUser(User user);

  int updateUser(User user);

}

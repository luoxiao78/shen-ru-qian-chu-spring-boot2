package net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.service;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.model.User;

import java.util.List;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-15
 */
public interface UserServiceJdbcTemplate {

  // 添加
  int insertUser(User user);

  // 根据指定id获取
  User getUser(Long id);

  // 获取指定用户名和注释获取
  List<User> findAll(String userName, String note);

  // 更新
  int updateUser(User user);

  // 根据id删除
  int deleteUser(Long id);

}

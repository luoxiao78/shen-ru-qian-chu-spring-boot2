package net.xiaoluo.learning.shenruqianchuspringboot2.chapter9.service;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter9.model.User;

import java.util.List;
import java.util.Optional;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-03-08
 */
public interface UserService {

  /**
   * 获取指定索引的用户数据
   * @param id 指定索引
   * @return 指定索引的用户信息
   */
  Optional<User> getUser(String id);

  /**
   * 根据指定用户名和note查找用户数据
   * @param userName 用户名称
   * @param note 用户note
   * @return 找到的第一个匹配的用户数据
   */
  Optional<User> findUser(String userName, String note);

  /**
   * 保存(用户未分配id)用户
   * 或更新用户(用户已分配id)
   * @param user 需要保存或更新的用户
   */
  User saveOrUpdateUser(User user);

  /**
   * 删除指定用户
   * 实际根据用户id删除
   * 如果用户尚未分配id,则删除数据库中第一个匹配的数据
   * @param user 需要被删除的用户
   */
  void deleteUser(User user);

  /**
   * 获取所有的用户
   * @return 包含所有用户的列表
   */
  List<User> getAll();

}

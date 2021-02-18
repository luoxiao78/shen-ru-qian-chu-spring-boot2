package net.xiaoluo.learning.shenruqianchuspringboot2.chapter6.dao;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-17
 */
@Repository
public interface UserDao {

  User getUser(Long id);

  int insertUser(User user);

  int updateUser(User user);
}

package net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.service.impl;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.dao.UserMyBatisDao;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.model.Sex;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.model.User;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-16
 */
@Service
public class UserServiceMyBatisImpl implements UserService {

  private UserMyBatisDao userDao;

  public UserServiceMyBatisImpl(UserMyBatisDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public User getUser(Long id) {
    return userDao.getUser(id);
  }

  @Override
  public List<User> findByNameAndSex(String userName, Sex sex) {
    return null;
  }

  @Override
  public int insertUser(User user) {
    return 0;
  }

  @Override
  public int deleteUser(Long id) {
    return 0;
  }

  @Override
  public int updateUser(User user) {
    return 0;
  }

}

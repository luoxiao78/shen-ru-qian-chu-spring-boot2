package net.xiaoluo.learning.shenruqianchuspringboot2.chapter6.service.impl;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.model.User;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter6.dao.UserDao;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter6.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-17
 */
@Service
public class UserServiceImpl implements UserService {

  private UserDao userDao;

  public UserServiceImpl(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
  public User getUser(Long id) {
    return userDao.getUser(id);
  }

  @Override
  @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
  public int insertUser(User user) {
    return userDao.insertUser(user);
  }

  @Override
  @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 1)
  public int updateUser(User user) {
    return userDao.updateUser(user);
  }

}

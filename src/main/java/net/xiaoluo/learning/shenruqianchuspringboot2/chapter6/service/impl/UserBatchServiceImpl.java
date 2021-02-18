package net.xiaoluo.learning.shenruqianchuspringboot2.chapter6.service.impl;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.model.User;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter6.dao.UserDao;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter6.service.UserBatchService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-18
 */
@Service
public class UserBatchServiceImpl implements UserBatchService {

  private UserDao userDao;

  public UserBatchServiceImpl(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  @Transactional(isolation = Isolation.READ_COMMITTED,
                 propagation = Propagation.REQUIRED)
  public int insertUsers(List<User> userList) {
    int count = 0;
    for (User user : userList) {
      userDao.insertUser(user);
      count++;
    } //end for userList
    return count;
  }

}

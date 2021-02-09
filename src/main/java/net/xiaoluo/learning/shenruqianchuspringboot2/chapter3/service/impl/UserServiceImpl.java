package net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.service.impl;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.model.User;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-09
 */
@Service
public class UserServiceImpl implements UserService {

  private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

  @Override
  public void userInfo(User user) {
    logger.info("编号:" + user.getId());
    logger.info("用户名称：" + user.getUserName());
    logger.info("备注：" + user.getNote());
  }

}

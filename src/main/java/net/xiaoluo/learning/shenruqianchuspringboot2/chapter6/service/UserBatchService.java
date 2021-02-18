package net.xiaoluo.learning.shenruqianchuspringboot2.chapter6.service;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.model.User;

import java.util.List;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-18
 */
public interface UserBatchService {

  int insertUsers(List<User> userList);

}

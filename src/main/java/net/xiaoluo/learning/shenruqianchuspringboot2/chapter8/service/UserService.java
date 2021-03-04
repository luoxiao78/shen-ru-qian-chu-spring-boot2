package net.xiaoluo.learning.shenruqianchuspringboot2.chapter8.service;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter8.model.User;

import java.util.List;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-03-03
 */
public interface UserService {

  void saveUser(User user);

  DeleteResult deleteUser(Long id);

  List<User> findUser(String userName, String note, int skip, int limit);

  UpdateResult updateUser(Long id, String userName, String note);

  User getUser(Long id);

}

package net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.service.impl;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.model.Sex;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.model.User;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.repository.UserRepository;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-16
 */
@Service
public class UserServiceJpaImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  public UserServiceJpaImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User getUser(Long id) {
    return userRepository.findById(id).get();
  }

  @Override
  public List<User> findByNameAndSex(String userName, Sex sex) {
    return userRepository.findByUserNameLikeAndSex(userName, sex.getId());
  }

  @Override
  public int insertUser(User user) {
    if (user.getId() != null) {
      throw new RuntimeException(("新用户不应该指定id"));
    }
    userRepository.save(user);
    return 1;
  }

  @Override
  public int deleteUser(Long id) {
    final Optional<User> userInDbOpt = userRepository.findById(id);
    if (userInDbOpt.isPresent()) {
      userRepository.deleteById(id);
      return 1;
    }
    return 0;
  }

  @Override
  public int updateUser(User user) {
    // todo: 数据没有发生变化时,是否不需要执行存入
    userRepository.save(user);
    return 1;
  }

}

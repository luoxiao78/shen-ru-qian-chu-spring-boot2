package net.xiaoluo.learning.shenruqianchuspringboot2.chapter9.service.impl;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter9.model.User;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter9.repository.UserRepository;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter9.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-03-08
 */
@Service
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Optional<User> getUser(String id) {
    return userRepository.findUserById(id);
  }

  @Override
  public Optional<User> findUser(String userName, String note) {
    return userRepository.findUserByUserNameAndNote(userName, note);
  }

  @Override
  public User saveOrUpdateUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public void deleteUser(User user) {
    userRepository.delete(user);
  }

  @Override
  public List<User> getAll() {
    return userRepository.findAll();
  }

}

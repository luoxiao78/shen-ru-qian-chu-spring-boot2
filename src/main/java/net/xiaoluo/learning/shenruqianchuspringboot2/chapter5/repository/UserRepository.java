package net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.repository;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-16
 */
public interface UserRepository extends JpaRepository<User, Long> {

  List<User> findByUserNameLikeAndSex(String userName, int sexId);

}

package net.xiaoluo.learning.shenruqianchuspringboot2.chapter9.repository;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter9.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-03-08
 */
@Repository
public interface UserRepository extends MongoRepository<User, Long> {

  Optional<User> findUserByUserNameAndNote(String userName, String note);

  Optional<User> findUserById(String id);
}

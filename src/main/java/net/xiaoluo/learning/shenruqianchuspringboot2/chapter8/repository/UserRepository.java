package net.xiaoluo.learning.shenruqianchuspringboot2.chapter8.repository;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter8.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-03-04
 */
@Repository
public interface UserRepository extends MongoRepository<User, Long> {

  List<User> findByUserNameLike(String userName);

  List<User> findUser(String userName, String note, int skip, int limit);

  DeleteResult delete(Long id);

  UpdateResult updateUser(Long id, String userName, String note);
}

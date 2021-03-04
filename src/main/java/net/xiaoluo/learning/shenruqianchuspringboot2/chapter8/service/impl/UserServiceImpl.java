package net.xiaoluo.learning.shenruqianchuspringboot2.chapter8.service.impl;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter8.model.User;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter8.service.UserService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-03-03
 */
@Service
public class UserServiceImpl implements UserService {

  private MongoTemplate mongoTemplate;

  public UserServiceImpl(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @Override
  public void saveUser(User user) {
    mongoTemplate.save(user, "user");
  }

  @Override
  public DeleteResult deleteUser(Long id) {
    final Criteria criteria = Criteria.where("id").is(id);
    Query query = Query.query(criteria);
    return mongoTemplate.remove(query, User.class);
  }

  @Override
  public List<User> findUser(String userName, String note, int skip, int limit) {
    final Criteria criteria = Criteria.where("userName").regex(userName)
                                   .and("note").regex(note);
    final Query query = Query.query(criteria).skip(skip).limit(limit);
    return mongoTemplate.find(query, User.class);
  }

  @Override
  public UpdateResult updateUser(Long id, String userName, String note) {
    final Criteria criteria = Criteria.where("id").is(id);
    final Query query = Query.query(criteria);
    final Update update = Update.update("userName", userName);
    update.set("note", note);
    return mongoTemplate.updateFirst(query, update, User.class);
  }

  @Override
  public User getUser(Long id) {
    return mongoTemplate.findById(id, User.class);
  }

}

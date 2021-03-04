package net.xiaoluo.learning.shenruqianchuspringboot2.chapter8.repository.impl;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter8.model.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-03-04
 */
@Repository
public class UserRepositoryImpl {
private MongoTemplate mongoTemplate;

  public UserRepositoryImpl(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  public List<User> findUser(String userName, String note, int skip, int limit) {
    final Criteria criteria = Criteria.where("userName").regex(userName)
                                   .and("note").regex(note);
    final Query query = Query.query(criteria).skip(skip).limit(limit);
    return mongoTemplate.find(query, User.class);
  }

  public DeleteResult delete(Long id) {
    final Criteria criteria = Criteria.where("id").is(id);
    final Query query = Query.query(criteria);
    return mongoTemplate.remove(query, User.class);
  }

  public UpdateResult updateUser(Long id, String userName, String note) {
    final Criteria criteria = Criteria.where("id").is(id);
    final Query query = Query.query(criteria);
    final Update update = Update.update("userName", userName);
    update.set("note", note);
    return mongoTemplate.updateFirst(query, update, User.class);
  }
}

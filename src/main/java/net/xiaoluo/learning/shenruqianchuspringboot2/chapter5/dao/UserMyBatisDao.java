package net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.dao;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-16
 */
@Repository
public interface UserMyBatisDao {

  User getUser(Long id);

}

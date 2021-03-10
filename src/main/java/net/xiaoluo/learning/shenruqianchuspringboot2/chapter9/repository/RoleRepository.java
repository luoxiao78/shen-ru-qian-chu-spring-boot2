package net.xiaoluo.learning.shenruqianchuspringboot2.chapter9.repository;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter9.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-03-08
 */
@Repository
public interface RoleRepository extends MongoRepository<Role, Long> {

}

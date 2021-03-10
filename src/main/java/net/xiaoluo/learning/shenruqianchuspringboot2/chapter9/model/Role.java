package net.xiaoluo.learning.shenruqianchuspringboot2.chapter9.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-03-08
 */
@Document("role")
public class Role {

  @Id
  private Long id;

  @Field("role_name")
  private String roleName;

  private String note;
}

package net.xiaoluo.learning.shenruqianchuspringboot2.chapter8.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-03-03
 */
@Document
public class User implements Serializable {

  private static final long serialVersionUID = -7895435231819517614L;

  @Id
  private Long id;

  @Field("user_name")
  private String userName;

  private String note;

  private List<Role> roles;


}

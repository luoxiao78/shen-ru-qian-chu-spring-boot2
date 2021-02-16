package net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.model;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.converter.SexConverter;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-15
 */
@Entity
@Table(name = "chapter5_user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "user_name")
  private String userName;
  @Convert(converter = SexConverter.class)
  private Sex sex;
  @Column(name = "note")
  private String note;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Sex getSex() {
    return sex;
  }

  public void setSex(Sex sex) {
    this.sex = sex;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return userName.equals(user.userName) && sex == user.sex && Objects.equals(note, user.note);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userName, sex, note);
  }

}


package net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-09
 */
@Primary
@Component("user")
public class User {

 @Value("1")
 private Long id;

 @Value("chapter3_user_1")
 private String userName;

 @Value("chapter3_note_1")
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

 public String getNote() {
  return note;
 }

 public void setNote(String note) {
  this.note = note;
 }

}

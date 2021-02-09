package net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-09
 */
@Primary
@Component
public class Cat implements Animal {

  @Override
  public String workInfo() {
    return String.format("动物-%s可以抓老鼠", Cat.class.getSimpleName());
  }

}

package net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.model;

import org.springframework.stereotype.Component;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-09
 */
@Component
public class Dog implements Animal {

  @Override
  public String workInfo() {
    return String.format("动物-%s可以用来看家", Dog.class.getSimpleName());
  }

}

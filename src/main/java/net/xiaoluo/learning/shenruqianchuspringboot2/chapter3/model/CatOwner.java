package net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.model;

import org.springframework.stereotype.Component;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-09
 */
@Component
public class CatOwner extends Owner{

  public CatOwner(Animal animal) {
    super(animal);
  }

}

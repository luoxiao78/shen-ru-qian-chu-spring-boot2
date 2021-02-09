package net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-09
 */
@Component
public class DogOwner extends Owner{

  public DogOwner(@Qualifier("dog") Animal animal) {
    super(animal);
  }

}

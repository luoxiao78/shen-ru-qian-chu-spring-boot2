package net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-09
 */
@Component
public class Owner implements Person {

  private static final Logger logger = LoggerFactory.getLogger(Owner.class);

  private Animal animal;

  public Owner(Animal animal) {
    this.animal = animal;
  }

  @Override
  public void service() {
    logger.info(animal.workInfo());
  }

  @Override
  public void setAnimal(Animal animal) {
    this.animal = animal;
  }

}

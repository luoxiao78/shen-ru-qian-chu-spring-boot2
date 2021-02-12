package net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.model;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-12
 */
public class Squirrel implements Animal {

  @Override
  public String workInfo() {
    return String.format("动物-%s可以采集松果", Squirrel.class.getSimpleName());
  }

}

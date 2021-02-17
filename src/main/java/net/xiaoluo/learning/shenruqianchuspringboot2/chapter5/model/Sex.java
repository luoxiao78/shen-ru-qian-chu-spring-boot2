package net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.model;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-15
 */
public enum Sex {
  // 男性
  MALE(1, "男"),
  // 女性
  FEMALE(2, "女");

  private final int id;
  private final String desc;

  Sex(int id, String desc) {
    this.id = id;
    this.desc = desc;
  }

  public static Sex getSexById(int id) {
    if (id == 1) {
      return MALE;
    }
    if (id == 2) {
      return FEMALE;
    }
    return null;
  }

  public int getId() {
    return id;
  }

  public String getDesc() {
    return desc;
  }
}

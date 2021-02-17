package net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.converter;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.model.Sex;

import javax.persistence.AttributeConverter;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-16
 */
public class SexConverter implements AttributeConverter<Sex, Integer> {

  @Override
  public Integer convertToDatabaseColumn(Sex sex) {
    return sex.getId();
  }

  @Override
  public Sex convertToEntityAttribute(Integer sexId) {
    return Sex.getSexById(sexId);
  }

}

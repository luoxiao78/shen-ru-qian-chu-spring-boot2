package net.xiaoluo.learning.shenruqianchuspringboot2.chapter3.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-11
 */
public class DatabaseConditonal implements Condition {

  @Override
  public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
    final Environment env = conditionContext.getEnvironment();
    return env.containsProperty("database.driverName")
           && env.containsProperty("database.url")
           && env.containsProperty("database.username")
           // will return false since no such property
           // && env.containsProperty("database.notExist")
           && env.containsProperty("database.password");
  }

}

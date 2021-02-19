package net.xiaoluo.learning.shenruqianchuspringboot2.chapter7;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter7.config.RedisConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-19
 */
// @SpringBootApplication
public class RedisDemo {

  public static void main(String[] args) {
    final ApplicationContext ctx = new AnnotationConfigApplicationContext(RedisConfig.class);
    final RedisTemplate redisTemplate = ctx.getBean(RedisTemplate.class);
    redisTemplate.opsForValue().set("key1", "value1");
    redisTemplate.opsForHash().put("hash", "field", "hvalue");
  }
}

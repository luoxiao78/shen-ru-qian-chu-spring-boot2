package net.xiaoluo.learning.shenruqianchuspringboot2.chapter7;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter7.config.RedisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-19
 */
@SpringBootApplication
public class RedisDemo {

  public static void main(String[] args) {
    SpringApplication.run(RedisConfig.class, args);
  }
}

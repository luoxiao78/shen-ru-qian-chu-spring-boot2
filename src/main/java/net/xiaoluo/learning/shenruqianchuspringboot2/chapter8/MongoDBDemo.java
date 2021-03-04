package net.xiaoluo.learning.shenruqianchuspringboot2.chapter8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-03-04
 */
@SpringBootApplication
@ComponentScan("net.xiaoluo.learning.shenruqianchuspringboot2.chapter8")
@PropertySource("classpath:application.properties")
public class MongoDBDemo {

  public static void main(String[] args) {
    SpringApplication.run(MongoDBDemo.class);
  }
}

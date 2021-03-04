package net.xiaoluo.learning.shenruqianchuspringboot2.chapter8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-03-04
 */
@SpringBootApplication(scanBasePackages = "net.xiaoluo.learning.shenruqianchuspringboot2.chapter8")
@EnableMongoRepositories("net.xiaoluo.learning.shenruqianchuspringboot2.chapter8.repository")
public class MongoDBDemo {

  public static void main(String[] args) {
    SpringApplication.run(MongoDBDemo.class);
  }
}

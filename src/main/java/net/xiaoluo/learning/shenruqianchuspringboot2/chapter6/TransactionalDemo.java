package net.xiaoluo.learning.shenruqianchuspringboot2.chapter6;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter6.config.TransactionConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-17
 */
@SpringBootApplication
public class TransactionalDemo {

  public static void main(String[] args) {
    SpringApplication.run(TransactionConfig.class, args);
  }

}

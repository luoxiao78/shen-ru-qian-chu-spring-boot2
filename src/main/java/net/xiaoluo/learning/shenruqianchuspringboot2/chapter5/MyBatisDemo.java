package net.xiaoluo.learning.shenruqianchuspringboot2.chapter5;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter5.config.MyBatisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-16
 */
@SpringBootApplication
public class MyBatisDemo {

  public static void main(String[] args) {
    SpringApplication.run(MyBatisConfig.class, args);
  }

}

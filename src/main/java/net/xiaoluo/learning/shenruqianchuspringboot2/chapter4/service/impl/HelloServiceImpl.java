package net.xiaoluo.learning.shenruqianchuspringboot2.chapter4.service.impl;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter4.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-12
 */
public class HelloServiceImpl implements HelloService {

  private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

  @Override
  public void sayHello(String targetName) {
    Objects.requireNonNull(targetName);
    logger.info(String.format("Hello, %s", targetName));
  }

}

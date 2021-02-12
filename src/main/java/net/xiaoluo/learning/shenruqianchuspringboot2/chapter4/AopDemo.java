package net.xiaoluo.learning.shenruqianchuspringboot2.chapter4;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter4.proxy.MyProxyFactory;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter4.service.HelloService;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter4.service.impl.HelloServiceImpl;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-12
 */
public class AopDemo {

  public static void main(String[] args) {
    final HelloService helloService = new HelloServiceImpl();
    final Object proxy = MyProxyFactory.getMyProxyBean(helloService, "interceptor");
    ((HelloService) proxy).sayHello("Xiao");
  }

}

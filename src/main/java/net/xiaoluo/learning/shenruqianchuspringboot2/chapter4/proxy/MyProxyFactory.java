package net.xiaoluo.learning.shenruqianchuspringboot2.chapter4.proxy;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter4.intercept.impl.MyInterceptor;

import java.lang.reflect.Proxy;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-12
 */
public class MyProxyFactory {

  public static Object getMyProxyBean(Object target, String proxyType) {

    MyProxy myProxy = null;

    if ("interceptor".equals(proxyType)) {
      myProxy = new InterceptorProxy(target, new MyInterceptor());
      return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                                    target.getClass().getInterfaces(),
                                    myProxy);
    }
    return null;
  }

}

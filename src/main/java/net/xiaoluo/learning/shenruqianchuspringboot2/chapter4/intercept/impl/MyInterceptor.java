package net.xiaoluo.learning.shenruqianchuspringboot2.chapter4.intercept.impl;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter4.intercept.Interceptor;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter4.invoke.Invocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-12
 */
public class MyInterceptor implements Interceptor {

  private static final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

  @Override
  public boolean before() {
    logger.info("before invocation....");
    return useAround();
  }

  @Override
  public void after() {
    logger.info("after invocation....");
  }

  @Override
  public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
    logger.info("around before....");
    final Object result = invocation.proceed();
    logger.info("around after....");
    return result;
  }

  @Override
  public void afterReturning() {
    logger.info("after returning....");
  }

  @Override
  public void afterThrowing() {
    logger.info("after throwing....");
  }

  @Override
  public boolean useAround() {
    return true;
  }

}

package net.xiaoluo.learning.shenruqianchuspringboot2.chapter4.invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-12
 */
public class Invocation {

  private Object[] parameters;
  private Method method;
  private Object target;

  public Invocation(Object[] parameters, Method method, Object target) {
    this.parameters = parameters;
    this.method = method;
    this.target = target;
  }

  public Object proceed() throws InvocationTargetException, IllegalAccessException {
    return method.invoke(target, parameters);
  }

}

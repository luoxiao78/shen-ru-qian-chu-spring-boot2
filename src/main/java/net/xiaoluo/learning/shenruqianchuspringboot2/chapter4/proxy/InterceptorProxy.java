package net.xiaoluo.learning.shenruqianchuspringboot2.chapter4.proxy;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter4.intercept.Interceptor;
import net.xiaoluo.learning.shenruqianchuspringboot2.chapter4.invoke.Invocation;

import java.lang.reflect.Method;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-12
 */
public class InterceptorProxy implements MyProxy {

  Object target;
  Interceptor interceptor;

  public InterceptorProxy(Object target, Interceptor interceptor) {
    this.target = target;
    this.interceptor = interceptor;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    boolean exceptionFlag = false;
    final Invocation invocation = new Invocation(args, method, target);
    Object result = null;
    try {
      if (interceptor.before()) {
        result = interceptor.around(invocation);
      } else {
        result = invocation.proceed();
      }
    } catch (Exception e) {
      exceptionFlag = true;
      e.printStackTrace();
    }
    interceptor.after();
    if (exceptionFlag) {
      interceptor.afterThrowing();
    } else {
      interceptor.afterReturning();
    }
    return result;
  }

  public Object getTarget() {
    return target;
  }

  public Interceptor getInterceptor() {
    return interceptor;
  }

}

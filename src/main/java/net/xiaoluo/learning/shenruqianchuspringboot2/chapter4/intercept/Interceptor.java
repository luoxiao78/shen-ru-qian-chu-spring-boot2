package net.xiaoluo.learning.shenruqianchuspringboot2.chapter4.intercept;

import net.xiaoluo.learning.shenruqianchuspringboot2.chapter4.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-12
 */
public interface Interceptor {

  /**
   * 事前方法
   * @return
   */
  boolean before();

  /**
   * 事后方法
   */
  void after();

  /**
   * 取代原有方法
   * @param invocation 回调参数,通过他的proceed方法,回调原事件.
   * @return 原有事件返回对象
   * @throws InvocationTargetException
   * @throws IllegalAccessException
   */
  Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException;

  /**
   * 正常结束时执行
   */
  void afterReturning();

  /**
   * 发生异常时执行
   */
  void afterThrowing();

  /**
   * 是否使用around方法代替原有方法
   * @return 是返回true
   */
  boolean useAround();

}

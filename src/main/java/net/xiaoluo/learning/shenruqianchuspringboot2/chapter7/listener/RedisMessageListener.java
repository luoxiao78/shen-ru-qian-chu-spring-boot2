package net.xiaoluo.learning.shenruqianchuspringboot2.chapter7.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-19
 */
@Component
public class RedisMessageListener implements MessageListener {

  @Override
  public void onMessage(Message message, byte[] topicPattern) {
    final String messageBody = new String(message.getBody());
    final String topic = new String(topicPattern);
    System.out.println(messageBody);
    System.out.println(topic);
  }

}

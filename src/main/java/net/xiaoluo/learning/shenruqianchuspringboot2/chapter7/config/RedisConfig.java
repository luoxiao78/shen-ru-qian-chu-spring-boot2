package net.xiaoluo.learning.shenruqianchuspringboot2.chapter7.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import javax.annotation.PostConstruct;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-18
 */
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("net.xiaoluo.learning.shenruqianchuspringboot2.chapter7")
public class RedisConfig {

  final private RedisTemplate redisTemplate;
  private RedisConnectionFactory redisConnectionFactory;
  private MessageListener redisMessageListener;
  private ThreadPoolTaskScheduler taskScheduler;

  public RedisConfig(RedisTemplate redisTemplate, RedisConnectionFactory redisConnectionFactory, MessageListener redisMessageListener) {
    this.redisTemplate = redisTemplate;
    this.redisConnectionFactory = redisConnectionFactory;
    this.redisMessageListener = redisMessageListener;
  }

  @PostConstruct
  public void init() {
    initRedisTemplate();
  }

  @Bean
  public ThreadPoolTaskScheduler initTaskScheduler() {
    if (taskScheduler != null) {
      return taskScheduler;
    }
    final ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
    threadPoolTaskScheduler.setPoolSize(20);
    return threadPoolTaskScheduler;
  }

  @Bean
  public RedisMessageListenerContainer initRedisMessageListenerContainer() {
    final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
    container.setConnectionFactory(redisConnectionFactory);
    container.setTaskExecutor(initTaskScheduler());
    final Topic topic = new ChannelTopic("topic1");
    container.addMessageListener(redisMessageListener, topic);
    return container;
  }

  private void initRedisTemplate() {
    final RedisSerializer<String> stringSerializer = redisTemplate.getStringSerializer();
    redisTemplate.setValueSerializer(stringSerializer);
    redisTemplate.setKeySerializer(stringSerializer);
    redisTemplate.setHashValueSerializer(stringSerializer);
  }

  /*
  private RedisConnectionFactory redisConnectionFactory;

  @Bean(name = "redisConnectionFactory")
  public RedisConnectionFactory initConnectionFactory() {
    if (redisConnectionFactory != null) {
      return redisConnectionFactory;
    }
    final JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
    jedisPoolConfig.setMaxTotal(50);
    jedisPoolConfig.setMaxIdle(30);
    jedisPoolConfig.setMaxWaitMillis(2000);
    final JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(jedisPoolConfig);
    final RedisStandaloneConfiguration standaloneConfiguration = jedisConnectionFactory.getStandaloneConfiguration();
    standaloneConfiguration.setHostName("localhost");
    standaloneConfiguration.setPort(6379);
    this.redisConnectionFactory = jedisConnectionFactory;
    return redisConnectionFactory;
  }

  @Bean(name = "redisTemple")
  public RedisTemplate<Object, Object> initRedisTemplate() {
    final RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
    final RedisSerializer<String> stringSerializer = redisTemplate.getStringSerializer();
    redisTemplate.setKeySerializer(stringSerializer);
    redisTemplate.setHashKeySerializer(stringSerializer);
    redisTemplate.setHashValueSerializer(stringSerializer);
    redisTemplate.setConnectionFactory(initConnectionFactory());
    return redisTemplate;
  }
  */

}

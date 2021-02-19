package net.xiaoluo.learning.shenruqianchuspringboot2.chapter7.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-18
 */
@Configuration
@PropertySource("classpath:application.properties")
public class RedisConfig {

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
    redisTemplate.setConnectionFactory(initConnectionFactory());
    return redisTemplate;
  }

}

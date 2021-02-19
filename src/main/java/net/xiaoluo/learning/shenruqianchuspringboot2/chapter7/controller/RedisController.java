package net.xiaoluo.learning.shenruqianchuspringboot2.chapter7.controller;

import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xiao Luo
 * @project shen-ru-qian-chu-spring-boot-2
 * @created 2021-02-19
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

  private RedisTemplate redisTemplate;
  private StringRedisTemplate stringRedisTemplate;

  public RedisController(RedisTemplate redisTemplate, StringRedisTemplate stringRedisTemplate) {
    this.redisTemplate = redisTemplate;
    this.stringRedisTemplate = stringRedisTemplate;
  }

  @RequestMapping("/stringAndHash")
  public Map<String, Object> testStringAndHash() {
    redisTemplate.opsForValue().set("key1", "value1");
    redisTemplate.opsForValue().set("int_key", "1");

    stringRedisTemplate.opsForValue().set("int", "1");
    stringRedisTemplate.opsForValue().increment("int", 1);

    Jedis jedis = (Jedis) stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();
    jedis.decr("int");

    final Map<String, String> hash = new HashMap<>();
    hash.put("field1", "value1");
    hash.put("field2", "value2");

    stringRedisTemplate.opsForHash().putAll("hash", hash);
    stringRedisTemplate.opsForHash().put("hash", "field3", "value3");

    final BoundHashOperations<String, Object, Object> hashOps = stringRedisTemplate.boundHashOps("hash");
    hashOps.delete("field1", "value1");
    hashOps.put("field4", "value4");
    final Map<String, Object> result = new HashMap<>();
    result.put("success", true);
    return result;
  }
}

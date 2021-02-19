package net.xiaoluo.learning.shenruqianchuspringboot2.chapter7.controller;

import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
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

  @RequestMapping("/list")
  public Map<String, Object> testList() {
    stringRedisTemplate.opsForList().leftPushAll("list1",
                                                 "v2", "v4", "v6", "v8", "v10");

    stringRedisTemplate.opsForList().rightPushAll("list2",
                                                  "v1", "v2", "v3", "v4", "v5", "v6");
    final BoundListOperations<String, String> listOps = stringRedisTemplate.boundListOps("list2");
    final String result1 = listOps.rightPop();
    final String result2 = listOps.index(1L);
    listOps.leftPush("v0");
    final Long size = listOps.size();
    final List<String> elements = listOps.range(0, size - 2);
    final Map<String, Object> resultMap = new HashMap<>();
    resultMap.put("success", true);
    return resultMap;
  }

}

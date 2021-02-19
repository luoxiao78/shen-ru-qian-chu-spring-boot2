package net.xiaoluo.learning.shenruqianchuspringboot2.chapter7.controller;

import org.springframework.data.domain.Range;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.connection.SortParameters;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.*;

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

  @RequestMapping("/set")
  public Map<String, Object> testSet() {
    redisTemplate.opsForSet().add("set1",
                                  "v1", "v1", "v2", "v3", "v4", "v5");
    redisTemplate.opsForSet().add("set2",
                                  "v2", "v4", "v6", "v8");
    final BoundSetOperations setOps = redisTemplate.boundSetOps("set1");
    setOps.add(("v6"), "v7");
    setOps.remove("v1", "v7");
    final Set set1 = setOps.members();
    final Long size = setOps.size();
    final Set inter = setOps.intersect("set2");
    setOps.intersectAndStore("set2", "inter");
    final Set diff = setOps.diff("set2");
    setOps.diffAndStore("set2", "diff");
    final Set union = setOps.union("set2");
    setOps.unionAndStore("set2", "union");
    final Map<String, Object> resutlMap = new HashMap<>();
    resutlMap.put("success", true);
    resutlMap.put("set1", set1);
    resutlMap.put("inter", inter);
    resutlMap.put("diff", diff);
    resutlMap.put("union", union);
    return resutlMap;
  }

  @RequestMapping("/zset")
  public Map<String, Object> testZset() {
    final HashSet<TypedTuple<String>> typedTupleSet = new HashSet<>();
    for (int i = 0; i < 10; i++) {
      double score = i * 0.1;
      final TypedTuple<String> typedTuple = new DefaultTypedTuple<>("value" + i, score);
      typedTupleSet.add(typedTuple);
    }
    stringRedisTemplate.opsForZSet().add("zset1", typedTupleSet);
    final BoundZSetOperations<String, String> zsetOps = stringRedisTemplate.boundZSetOps("zset1");
    zsetOps.add("value10", 0.26);
    final Set<String> setRange = zsetOps.range(1L, 6L);
    final Set<String> setScore = zsetOps.rangeByScore(0.2, 0.6);

    final RedisZSetCommands.Range range = new RedisZSetCommands.Range();
    range.gt("value3");
    range.lte("value8");
    final Set<String> setLex = zsetOps.rangeByLex(range);
    zsetOps.remove("value9", "value2");
    final Double score = zsetOps.score("value8");
    final Set<TypedTuple<String>> rangeSet = zsetOps.rangeWithScores(1L, 6L);
    final Set<TypedTuple<String>> scoreSet = zsetOps.rangeByScoreWithScores(0.2, 0.6);

    final Set<String> reverseSet = zsetOps.reverseRange(2L, 8L);
    final Map<String, Object> resultMap = new HashMap<>();
    resultMap.put("success", true);
    resultMap.put("set by range", setRange);
    resultMap.put("set by score", setScore);
    resultMap.put("set by lex", setLex);
    resultMap.put("score of value8", score);
    resultMap.put("set by range with score", rangeSet);
    resultMap.put("set by score with score", scoreSet);
    resultMap.put("reversed set by range", reverseSet);
    return resultMap;
  }


}

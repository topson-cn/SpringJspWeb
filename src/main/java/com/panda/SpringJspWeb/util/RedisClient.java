package com.panda.SpringJspWeb.util;

import lombok.Data;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RedisClient {

    private JedisPool jedisPool;

    public RedisClient() {
    }

    public RedisClient(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public void set(String key, String value){
        Jedis jedis = jedisPool.getResource();
        jedis.set(key,value);
    }

    public String get(String key){
        Jedis jedis = jedisPool.getResource();
        return jedis.get(key);
    }
}

package com.panda.SpringJspWeb.controller;

import com.panda.SpringJspWeb.util.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.JedisPool;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisClient redisClient;

    @RequestMapping("test1")
    @ResponseBody
    public String test1(){
        stringRedisTemplate.opsForValue().set("abc", "djq");
        return stringRedisTemplate.opsForValue().get("abc");
    }

    @RequestMapping("test2")
    @ResponseBody
    public String test2(){
        redisClient.set("bcd", "sbbb");
        return redisClient.get("bcd");
    }
}

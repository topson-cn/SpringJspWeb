package com.panda.SpringJspWeb.config;

import com.panda.SpringJspWeb.properties.MysqlProperties;
import com.panda.SpringJspWeb.properties.RedisProperties;
import com.panda.SpringJspWeb.util.RedisClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Configuration
@ConditionalOnClass(RedisClient.class)
public class RedisConfig {

    private Logger logger = LoggerFactory.getLogger(RedisConfig.class);

    @Autowired
    private RedisProperties prop;

    @Autowired
    private MysqlProperties mysql;

    @Bean
    public JedisPool jedisPool(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(prop.getMaxTotal());
        config.setMaxIdle(prop.getMaxIdle());
        config.setMaxWaitMillis(prop.getMaxWaitMillis());
        return new JedisPool(config, prop.getHost(), prop.getPort(), prop.getTimeOut());
    }

    @Bean
    public RedisClient redisClient(){
        logger.info("初始化……Redis Client==Host={},Port={}", prop.getHost(), prop.getPort());
        RedisClient redisClient = new RedisClient(jedisPool());
        return redisClient;
    }
}

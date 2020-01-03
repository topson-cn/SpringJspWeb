package com.panda.SpringJspWeb.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Data
@Component
@ConfigurationProperties(prefix="redis.server")
@PropertySource("classpath:/config/redis.properties")
public class RedisProperties {

    private String host;

    private int port;

    private String password;

    private int maxTotal;

    private int maxIdle;

    private int maxWaitMillis;

    private int timeOut;


}

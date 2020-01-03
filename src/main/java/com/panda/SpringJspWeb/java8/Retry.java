package com.panda.SpringJspWeb.java8;


import com.github.rholder.retry.*;
import com.google.common.base.Predicates;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Retry {


    public Retryer<Boolean> buid(){
        Retryer<Boolean> retryer = RetryerBuilder
                .<Boolean>newBuilder()
                //抛出runtime异常、checked异常时都会重试，但是抛出error不会重试。
                .retryIfException()
                //返回false也需要重试
                .retryIfResult(Predicates.equalTo(false))
                //重调策略
                .withWaitStrategy(WaitStrategies.fixedWait(10, TimeUnit.SECONDS))
                //尝试次数
                .withStopStrategy(StopStrategies.stopAfterAttempt(3))
                .build();
        return retryer;
    }
}

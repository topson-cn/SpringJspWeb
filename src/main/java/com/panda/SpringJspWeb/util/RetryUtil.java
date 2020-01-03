package com.panda.SpringJspWeb.util;

import com.github.rholder.retry.*;
import com.google.common.base.Predicates;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RetryUtil {

    private static Retryer retryer;

    private static int RETRY_TIMES;

    private static int RETRY_RATE;

    private static TimeUnit TIME_UINT;

    public static Retryer getDefultInstance(){
        RETRY_TIMES = 3;
        RETRY_RATE = 2;
        TIME_UINT = TimeUnit.SECONDS;
        retryer = RetryerBuilder
                .<Boolean>newBuilder()
                // 抛出runtime异常、checked异常时都会重试，但是抛出error不会重试。
                .retryIfException()
                .retryIfResult(Predicates.isNull())
                // 自定义 指定返回值 也需要重试：返回false也需要重试
                .retryIfResult(Predicates.equalTo(false))
                .withStopStrategy(StopStrategies.stopAfterAttempt(RETRY_TIMES))
                .withWaitStrategy(WaitStrategies.fixedWait(RETRY_RATE, TIME_UINT))
                .withRetryListener(new MyRetryListener<>())
                .build();
        return retryer;
    }

    public static void main(String[] args) throws ExecutionException, RetryException {
        RetryUtil.getDefultInstance().call(() -> {
            return false;
        });
    }
}

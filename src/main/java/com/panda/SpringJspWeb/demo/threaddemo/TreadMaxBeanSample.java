package com.panda.SpringJspWeb.demo.threaddemo;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TreadMaxBeanSample implements Runnable{

    private String name;

    private String first;

    private String second;

    @Override
    public void run() {

        synchronized (first){
            System.out.println(this.getName() + " obtained: " + first);
            try {
                Thread.sleep(1000l);
                synchronized (second){
                    System.out.println(this.getName() + " obtained: " + second);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    public static void main(String[] args) throws InterruptedException {

        ThreadMXBean mbean = ManagementFactory.getThreadMXBean();
        Runnable dlCheck = new Runnable() {

            @Override
            public void run() {
                long[] threadIds = mbean.findDeadlockedThreads();
                if (threadIds != null) {
                    ThreadInfo[] threadInfos = mbean.getThreadInfo(threadIds);
                    System.out.println("Detected deadlock threads:");
                    for (ThreadInfo threadInfo : threadInfos) {
                        System.out.println(threadInfo.getThreadName());
                    }
                }
            }
        };

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        // 稍等5秒，然后每10秒进行一次死锁扫描
        scheduler.scheduleAtFixedRate(dlCheck, 5L, 10L, TimeUnit.SECONDS);
        // 死锁样例代码…
        String lockA = "lockA";
        String lockB = "lockB";
        TreadMaxBeanSample thread1 = new TreadMaxBeanSample("thread1", lockA, lockB);
        TreadMaxBeanSample thread2 = new TreadMaxBeanSample("thread2", lockB, lockA);
        new Thread(thread1).start();
        new Thread(thread2).start();
    }

    public TreadMaxBeanSample(String name, String first, String second) {
        this.name = name;
        this.first = first;
        this.second = second;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }
}

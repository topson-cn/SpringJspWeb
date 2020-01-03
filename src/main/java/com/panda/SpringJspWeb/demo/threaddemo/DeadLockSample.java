package com.panda.SpringJspWeb.demo.threaddemo;


/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DeadLockSample implements Runnable {

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

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        DeadLockSample thread1 = new DeadLockSample("thread1", lockA, lockB);
        DeadLockSample thread2 = new DeadLockSample("thread2", lockB, lockA);
        new Thread(thread1).start();
        new Thread(thread2).start();
    }

    public DeadLockSample(String name, String first, String second) {
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

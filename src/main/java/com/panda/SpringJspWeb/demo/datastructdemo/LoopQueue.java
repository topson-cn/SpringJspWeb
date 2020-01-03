package com.panda.SpringJspWeb.demo.datastructdemo;

/**
 * 〈一句话功能简述〉<br>
 * 循环队列: 数组实现
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LoopQueue<E> {

    private Object[] data;

    private int maxSize;

    private int front;

    private int rear;

    public LoopQueue(){
        this(10);
    }

    public LoopQueue(int initSize){
        if (initSize < 0){
            throw new RuntimeException("初始化长度不能小于0: " + initSize);
        }
        this.data = new Object[initSize];
        this.maxSize =  initSize;
        this.rear = this.front = 0;
    }

    public boolean enqueue(E e){
        if ((rear+1) % data.length == front){
            throw new RuntimeException("队列已满");
        }
        data[rear] = e;
        rear = (rear+1) % data.length;
        return true;
    }

    public E peek(){
        if (rear == front){
            throw new RuntimeException("队列已空");
        }
        return (E) data[front];
    }

    public E poll(){
        if (rear == front){
            throw new RuntimeException("队列已空");
        }
        E value = (E) data[front];
        data[front] = null;
        front = (front+1) % data.length;
        return value;
    }
}

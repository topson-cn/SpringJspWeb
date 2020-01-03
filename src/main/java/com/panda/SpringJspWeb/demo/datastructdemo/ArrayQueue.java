package com.panda.SpringJspWeb.demo.datastructdemo;

/**
 * 〈一句话功能简述〉<br>
 * 队列: 数组实现
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ArrayQueue<E> {

    // 物理结构
    private Object[] data;

    // 队头
    private int front;

    // 队尾
    private int rear;

    // 队列容量
    private int maxSize;

    public ArrayQueue(){
        this(10);
    }

    public ArrayQueue(int initSize){
        if (initSize < 0) {
            throw new RuntimeException("初始化容量不能小于0: " + initSize);
        }
        this.data = new Object[initSize];
        this.front = this.rear = 0;
        this.maxSize = initSize;
    }

    /**
     * 入队
     * @param e
     * @return
     */
    public Boolean enqueue(E e){
        if (rear == maxSize -1){
            throw new RuntimeException("队列已满");
        }
        data[rear++] = e;
        return true;
    }

    /**
     * 返回对首,但不删除
     * @return
     */
    public E peek(){
        if (rear == front){
            throw new RuntimeException("队列已空");
        }
        return (E) data[front];
    }

    /**
     * 出队
     * @return
     */
    public E poll(){
        if (rear == front){
            throw new RuntimeException("队列已空");
        }
        Object value = data[front];
        data[front++] = null;// 释放队列front位置的元素
        return (E) value;
    }

    public int length(){
        return rear - front;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue=new ArrayQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < queue.length(); i++) {
            System.out.print(queue.peek()+" ");
        }
        System.out.println();
        int size=queue.length();
        for (int i = 0; i < size; i++) {
            System.out.print(queue.poll()+" ");
        }
    }
}

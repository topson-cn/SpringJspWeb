package com.panda.SpringJspWeb.demo.datastructdemo;

/**
 * 〈一句话功能简述〉<br>
 * 链表实现队列
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LinkedQueue<E> {

    // 链栈的节点
    private class Node<E> {
        E e;

        Node<E> next;

        public Node() {
        }

        public Node(E e, Node<E> next) {
            this.e = e;
            this.next = next;
        }
    }

    // 队列头，允许删除
    private Node<E> front;
    // 队列尾，允许插入
    private Node<E> rear;

    private int size;

    public LinkedQueue() {
        this.front = null;
        this.rear = null;
    }

    // 判空
    public Boolean empty() {
        return size == 0;
    }

    // 插入
    public Boolean add(E e) {
        if (empty()) {
            front = new Node<>(e, null);
            rear = front;
        } else {
            Node<E> newNode = new Node<>(e, null);
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        return true;
    }

    // 获取队首，但不出队
    public Node<E> peek() {
        if (empty()) {
            throw new RuntimeException("队列已空");
        }
        return front;
    }

    // 出队
    public Node<E> poll() {
        if (empty()) {
            throw new RuntimeException("队列已空");
        }
        Node<E> ret = front;
        front = front.next;
        ret.next = null;
        size--;
        return ret;
    }

    public int length() {
        return size;
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.add(i);
        }
        for (int i = 0; i < queue.length(); i++) {
            System.out.print(queue.peek().e + " ");
        }
        System.out.println();
        int size = queue.length();
        for (int i = 0; i < size; i++) {
            System.out.print(queue.poll().e + " ");
        }
    }
}

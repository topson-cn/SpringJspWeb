package com.panda.SpringJspWeb.demo.datastructdemo;

/**
 * 〈一句话功能简述〉<br>
 * 栈: 链表实现
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class LinkedStack<E> {

    // 链栈的结点
    private class Node<E>{

        private E e;

        private Node<E> next;

        public Node(E e, Node<E> next) {
            this.e = e;
            this.next = next;
        }

        public E getE() {
            return e;
        }
    }

    // 栈顶元素
    private Node<E> top;

    // 当前栈大小
    private int size;

    public LinkedStack() {
        this.top = null;
    }

    /**
     * 入栈
     * @param e
     * @return
     */
    public Boolean push(E e){
        top = new Node<>(e, top);
        size++;
        return true;
    }

    /**
     * 出栈都不删除
     * @return
     */
    public Node<E> peek(){
        if (empty()){
            throw new RuntimeException("栈为空");
        }
        return top;
    }

    /**
     * 出栈并删除
     * @return
     */
    public Node<E> pop(){
        if (empty()){
            throw new RuntimeException("栈为空");
        }
        Node result = top;
        top = top.next;
        result.next = null;
        size--;
        return result;
    }

    public Boolean empty(){
        return size == 0;
    }

    public static void main(String[] args) {
        LinkedStack<Integer> stack=new LinkedStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(stack.pop().getE()+" ");
        }
    }
}

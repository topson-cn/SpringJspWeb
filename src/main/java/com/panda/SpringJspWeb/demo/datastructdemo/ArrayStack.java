package com.panda.SpringJspWeb.demo.datastructdemo;

/**
 * 〈一句话功能简述〉<br>
 * 栈: 数组实现
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ArrayStack<T> {

    // 物理结构
    private Object[] data = null;

    // 栈顶指针
    private int top;

    // 栈容量
    private int maxSize;

    public ArrayStack() {
        this(10);
    }

    public ArrayStack(int initSize) {
        if (initSize > 0) {
            this.maxSize = initSize;
            this.top = -1;
            this.data = new Object[initSize];
        } else {
            throw new RuntimeException("初始化值不能小于0:" + initSize);
        }
    }

    /**
     * 入栈操作
     *
     * @param t
     * @return
     */
    public Boolean push(T t) {
        if (top == maxSize - 1) {
            throw new RuntimeException("栈已满,无法执行入栈操作");
        }
        data[++top] = t;
        return true;
    }

    /**
     * 弹出栈顶元素,但不移除
     *
     * @return
     */
    public T peek() {
        if (top == -1) {
            throw new RuntimeException("栈已空");
        }
        return (T) data[top];
    }

    /**
     * 弹出栈顶元素,并移除
     *
     * @return
     */
    public T pop() {
        if (top == -1) {
            throw new RuntimeException("栈为空");
        }
        return (T) data[top--];
    }

    /**
     * 判空
     *
     * @return
     */
    public Boolean isEmpty() {
        return top == -1;
    }

    /**
     * 返回对象在栈中的位置
     *
     * @param e
     * @return
     */
    public int index(T e) {
        int i = top;
        while (!isEmpty()) {
            if (peek() != e) {
                top--;
            } else {
                break;
            }
        }
        int result = top + 1;
        top = i;
        return result;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(stack.index(i));
        }
    }
}

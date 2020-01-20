package com.panda.SpringJspWeb.demo.DesignPatternDemo.Observer;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BinaryObserver extends Observer {

    /**
     * 在构造方法中进行主题订阅
     * @param subject
     */
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        // 通常在构造方法中将this发布出去
        this.subject.attach(this);
    }

    @Override
    public void update() {
        String result = Integer.toBinaryString(subject.getState());
        System.out.println("订阅数据发生变化,新的处理数据为二进制值:" + result);
    }
}

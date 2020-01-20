package com.panda.SpringJspWeb.demo.DesignPatternDemo.Observer;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HexObserver extends Observer {

    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        String result = Integer.toHexString(subject.getState());
        System.out.println("订阅数据发生变化,新的处理数据为十六进制:" + result);
    }
}

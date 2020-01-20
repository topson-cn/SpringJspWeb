package com.panda.SpringJspWeb.demo.DesignPatternDemo.Observer;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Main {

    public static void main(String[] args) {
        // 定义主题
        Subject subject = new Subject();
        // 定义观察者
        BinaryObserver binaryObserver = new BinaryObserver(subject);
        HexObserver hexObserver = new HexObserver(subject);
        // 模拟数据变更
        subject.setState(11);
    }
}

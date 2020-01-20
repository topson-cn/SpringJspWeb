package com.panda.SpringJspWeb.demo.DesignPatternDemo.Observer;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    @Getter
    private int state;

    /**
     * 注册观察者
     * @param observer
     */
    public void attach(Observer observer){
        this.observers.add(observer);
    }

    public void setState(int state) {
        this.state = state;
        // 通知所有观察者
        notifyAllObserver();
    }

    private void notifyAllObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

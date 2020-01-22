package com.panda.SpringJspWeb.demo.DesignPatternDemo.strategy.common;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class StrategyContext {

    /**
     * 持有一个策略实现的引用
     */
    private IStratege stratege;

    /**
     * 使用构造器注入具体的策略类
     * @param stratege
     */
    public StrategyContext(IStratege stratege) {
        this.stratege = stratege;
    }

    public void contextMethod(){
        // 调用策略实现的方法
        this.stratege.algorithmMethod();
    }
}

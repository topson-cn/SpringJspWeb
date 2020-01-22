package com.panda.SpringJspWeb.demo.DesignPatternDemo.strategy.type1;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Client {

    public static void main(String[] args) {
        // 创建具体的策略实现
        IStratege stratege = new ConcreteStrategy2();
        // 创建策略上下文对象,并把具体策略注入
        StrategyContext context = new StrategyContext(stratege, "aaa");
        // 调用上下文对象方法完成对具体策略实习的回调
        context.contextMethod();
    }
}

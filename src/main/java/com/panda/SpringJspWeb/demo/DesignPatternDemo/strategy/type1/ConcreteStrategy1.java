package com.panda.SpringJspWeb.demo.DesignPatternDemo.strategy.type1;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ConcreteStrategy1 implements IStratege{
    @Override
    public void algorithmMethod(StrategyContext ctx) {
        System.out.println("this is ConcreteStrategy1 method...with name:" + ctx.getName());
    }
}

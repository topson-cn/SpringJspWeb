package com.panda.SpringJspWeb.demo.strategy.type1;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ConcreteStrategy2 implements IStratege{
    @Override
    public void algorithmMethod(StrategyContext ctx) {
        System.out.println("this is ConcreteStrategy2 method...with name:" + ctx.getName());
    }
}

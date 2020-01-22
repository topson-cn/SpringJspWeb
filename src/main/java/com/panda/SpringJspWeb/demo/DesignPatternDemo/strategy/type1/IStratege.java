package com.panda.SpringJspWeb.demo.DesignPatternDemo.strategy.type1;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IStratege {

    /**
     * 在策略接口的方法中含有上下文对象的参数,方便在具体策略中回调上下文中方法获取数据
     * @param ctx
     */
    void algorithmMethod(StrategyContext ctx);
}

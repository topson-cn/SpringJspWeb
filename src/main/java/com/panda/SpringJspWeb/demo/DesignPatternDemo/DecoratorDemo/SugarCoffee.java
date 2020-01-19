package com.panda.SpringJspWeb.demo.DesignPatternDemo.DecoratorDemo;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SugarCoffee extends DrinkDecorator {
    public SugarCoffee(Drink drink) {
        super(drink);
    }

    @Override
    public float cost() {
        return super.cost() + 5;
    }

    @Override
    public String description() {
        return super.description() + " with sugar";
    }
}

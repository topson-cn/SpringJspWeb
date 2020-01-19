package com.panda.SpringJspWeb.demo.DesignPatternDemo.DecoratorDemo;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DecoratorLab {

    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        System.out.println(coffee.description() + ",cost" + coffee.cost());
        MilkCoffee milkCoffee = new MilkCoffee(coffee);
        System.out.println(milkCoffee.description() + ",cost" + milkCoffee.cost());
        SugarCoffee sugarCoffee = new SugarCoffee(coffee);
        System.out.println(sugarCoffee.description() + ",cost" + sugarCoffee.cost());
    }
}

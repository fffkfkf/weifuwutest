package cn.dell.factory.simplefactory.order;

import cn.dell.factory.simplefactory.pizza.CheesePizza;
import cn.dell.factory.simplefactory.pizza.GreekPizza;
import cn.dell.factory.simplefactory.pizza.Pizza;

/**
 * @author gmq
 * @date 2020/1/28
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class SimpleFactory {

    public Pizza creatPizza(String orderType) {
        Pizza pizza = null;
        System.out.println("使用简单工厂");
        if ("greek".equals(orderType)) {
            pizza = new GreekPizza();
            pizza.setName("希腊披萨");
        } else if ("cheese".equals(orderType)) {
            pizza = new CheesePizza();
            pizza.setName("奶酪披萨");
        } else if ("pepper".equals(orderType)) {
            pizza = new CheesePizza();
            pizza.setName("胡椒披萨");
        }

        return pizza;
    }


}

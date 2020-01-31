package cn.dell.factory.simplefactory.order;

/**
 * @author gmq
 * @date 2020/1/28
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class PizzaStore {
    public static void main(String[] args) {

        new OrderPizza(new SimpleFactory());
    }


}

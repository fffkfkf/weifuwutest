package cn.dell.factory.simplefactory.order;

import cn.dell.factory.simplefactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author gmq
 * @date 2020/1/28
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class OrderPizza {

    SimpleFactory simpleFactory;
    Pizza pizza=null;

    public OrderPizza() {
    }

    public OrderPizza(SimpleFactory simpleFactory) {
        setFactory(simpleFactory);
    }

    private void setFactory(SimpleFactory simpleFactory) {
        String orderType="";
        this.simpleFactory=simpleFactory;
        do{
            orderType=getType();
            pizza=this.simpleFactory.creatPizza(orderType);
            if (pizza!=null){
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else {
                System.out.println("订购失败");
                break;

            }
        }while (true);

    }

    private String getType() {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入种类:");
        try {
            String s = buff.readLine();
            return s;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}

package cn.dell.strategy;

/**
 * @author gmq
 * @date 2020/1/24
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Client {
    public static void main(String[] args) {
        Duck beijingDuck = new BeijingDuck();
        beijingDuck.fly();
        //需要改变：
        beijingDuck.setFlyBehavior(new CommonFly());
        beijingDuck.fly();

    }

}
package cn.dell.strategy;

/**
 * @author gmq
 * @date 2020/1/24
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class CommonFly implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("飞的一般");
    }
}

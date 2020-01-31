package cn.dell.strategy;

/**
 * @author gmq
 * @date 2020/1/24
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class GoodSing implements SingBehavor {
    @Override
    public void sing() {
        System.out.println("叫的很好");
    }
}
package cn.dell.strategy;

/**
 * @author gmq
 * @date 2020/1/24
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public abstract class Duck {
    FlyBehavior flyBehavior;
    SingBehavor singBehavor;

    public void fly() {
        flyBehavior.fly();

    }

    public void sing() {
        singBehavor.sing();

    }

    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
}

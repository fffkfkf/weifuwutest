package cn.dell.factory.simplefactory.pizza;

/**
 * @author gmq
 * @date 2020/1/28
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public abstract class Pizza {
    private String name;

    //准备原材料, 不同的披萨不一样，因此，我们做成抽象方法
    public abstract void prepare();

    public void bake() {
        System.out.println(name + " baking;");
    }

    public void cut() {
        System.out.println(name + " cutting;");
    }

    //打包
    public void box() {
        System.out.println(name + " boxing;");
    }

    public void setName(String name) {
        this.name = name;
    }


}

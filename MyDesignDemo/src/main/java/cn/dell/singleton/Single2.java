package cn.dell.singleton;

/**
 * 双重检查(懒汉式)
 * @author gmq
 * @date 2020/7/23
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Single2 {

    private static volatile Single2 instance;

    private Single2() {
    }

    ///提供一个静态的公有方法，加入双重检查代码，解决线程安全问题, 同时解决懒加载问题
    public static synchronized Single2 getInstance() {
        if (instance == null) {
            synchronized (Single2.class) {
                if (instance == null) {
                    instance = new Single2();
                }
            }
        }
        return instance;
    }

}

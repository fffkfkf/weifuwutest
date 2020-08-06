package cn.dell.singleton;

/**
 * 双重检查
 * @author gmq
 * @date 2020/8/4
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class STest2 {

    private static volatile STest2 sTest2;
    private STest2() {

    }

    public static synchronized STest2 getins() {
        if (sTest2 == null) {
            synchronized (STest2.class) {
                if (sTest2 == null) {
                    sTest2 = new STest2();
                }
            }
        }
        return sTest2;
    }

}

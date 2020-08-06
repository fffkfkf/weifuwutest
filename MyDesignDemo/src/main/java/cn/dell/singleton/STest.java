package cn.dell.singleton;

/**
 * 静态内部类
 *
 * @author gmq
 * @date 2020/8/4
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class STest {

    private STest() {

    }

    private static class Singl {
        private static final STest S_TEST = new STest();
    }

    public static STest getInst() {
        return Singl.S_TEST;
    }


}

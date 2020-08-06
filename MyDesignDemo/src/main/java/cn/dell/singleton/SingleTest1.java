package cn.dell.singleton;

/**
 * @author gmq
 * @date 2020/7/23
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class SingleTest1 {
    public static void main(String[] args) {
        Single1 instance = Single1.getInstance();
        Single1 instance1 = Single1.getInstance();
        System.out.println(instance==instance1);
        Single0 single0 = new Single0();
        Single0 single1 = new Single0();
        System.out.println(single0==single1);

        STest inst = STest.getInst();
        STest inst2 = STest.getInst();
        System.out.println(inst==inst2);

        STest2 getins = STest2.getins();
        STest2 getins2 = STest2.getins();
        System.out.println(getins==getins2);



    }

}

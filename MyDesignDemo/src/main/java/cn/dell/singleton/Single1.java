package cn.dell.singleton;

/**
 * 静态内部类(饿汉式)
 * @author gmq
 * @date 2020/7/23
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public  class Single1 {

    //构造器私有化
    private Single1(){

    }
    //静态内部类,有一个静态属性.
    private static class  SingleIn{
        private static final Single1 SINGLE_1 =new Single1();
    }
    //提供静态方法
    public static Single1 getInstance(){
        return SingleIn.SINGLE_1;
    }


}

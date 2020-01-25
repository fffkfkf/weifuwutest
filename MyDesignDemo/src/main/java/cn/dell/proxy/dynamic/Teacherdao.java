package cn.dell.proxy.dynamic;

/**
 * @author gmq
 * @date 2020/1/24
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Teacherdao implements ITeacherDao {
    @Override
    public void sayHello(String name) {
        System.out.println("hello: "+name);
    }

    @Override
    public void sing(String name) {
        System.out.println("hello,sing: "+name);
    }
}

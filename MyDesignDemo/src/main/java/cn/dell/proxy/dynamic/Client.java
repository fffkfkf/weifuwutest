package cn.dell.proxy.dynamic;

/**
 * @author gmq
 * @date 2020/1/24
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Client {
    public static void main(String[] args) {

        ITeacherDao target = new Teacherdao();
        ITeacherDao iTeacherDao =
                (ITeacherDao) new ProxyFactory(target).getProxyInstance();
        iTeacherDao.sayHello("tom");
        iTeacherDao.sing("singtom");

    }




}

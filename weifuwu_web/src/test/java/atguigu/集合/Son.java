package atguigu.集合;

import org.junit.Test;

/**
 * @author gmq
 * @date 2020/8/15
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Son extends Father{

    private static String name = "zlc";
    private int age = 26;
    {
        System.out.println("son age: "+age);
        System.out.println("son 我是普通代码块");
    }

    static{
        System.out.println("son static name: "+name);
        System.out.println("son 我是静态代码块");
    }

    public Son(){
        System.out.println("son 我是构造函数");
    }

    @Test
    public void test(){
        Son son = new Son();
    }
}


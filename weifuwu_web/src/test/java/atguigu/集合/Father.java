package atguigu.集合;

/**
 * @author gmq
 * @date 2020/8/15
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Father {

    private static String name = "zct";
    private int age = 50;

    static{
        System.out.println("father static name: "+name);
        System.out.println("father 我是静态代码块");
        System.out.println("father 我是静态代码块");
    }


    public Father(){
        System.out.println("father 我是构造函数");
    }
    {
        System.out.println("father age: "+age);
        System.out.println("father 我是普通代码块");
    }


}

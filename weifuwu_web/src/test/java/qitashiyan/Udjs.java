package qitashiyan;

import bingfa.CreatThread1;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * lamda匿名内部类
 * @author gmq
 * @date 2020/8/8
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Udjs {

    @Test
    public void coutaa() {
        int cc = 2;
        Sercc ss = () -> {
            int name = getName(cc);
            System.out.println(name);
        };
        ss.metdt();
    }

    interface Sercc {
        void metdt();
    }

    public int getName(int aa) {
        return aa;
    }


    //反射使用:
    @Test
    public void fanshe() throws Exception {

        Class clazz = null;
        try {
            clazz = Class.forName("bingfa.CreatThread1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 根据是否有有参构造来定.
        Constructor constructor = clazz.getConstructor();
        CreatThread1 obj = (CreatThread1)constructor.newInstance();

        System.out.println(obj);
       /* Method method = clazz.getMethod("sss");

        Object invoke = method.invoke(obj);
        System.out.println(22);
        System.out.println(invoke);*/


    }



}

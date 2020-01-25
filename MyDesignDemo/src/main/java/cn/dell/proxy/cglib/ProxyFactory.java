package cn.dell.proxy.cglib;

import com.sun.org.apache.xpath.internal.Arg;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author gmq
 * @date 2020/1/25
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class ProxyFactory implements MethodInterceptor {
private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects,
                            MethodProxy methodProxy) throws Throwable {
        System.out.println("代理之前要做的");
        Object invoke = method.invoke(target, objects);
        System.out.println("代理之后要做的----");


        return invoke;
    }
}

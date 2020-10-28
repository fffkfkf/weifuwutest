package jichu.jdk动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author gmq
 * @Description
 * @date 2020/10/27
 */
public class HelloServicePeoxy implements InvocationHandler {

    //真实服务的对象
    private Object target;

    public Object bind(Object target){
        this.target=target;
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        return Proxy.newProxyInstance(classLoader, interfaces,this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       Object result=null;
        System.out.println("我准备说hello....");

        result = method.invoke(target, args);
        System.out.println("我说hello之后....");

        return result;
    }




}

package jichu.jdk动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 通过反射机制给接口(IExample)生成对象 / 模拟mybatis的执行流程.
 *
 * @author gmq
 * @Description
 * @date 2020/10/29
 */
public class MyProxyView implements InvocationHandler {

    public static Object newInstance(Class[] interfaces) {
        return Proxy.newProxyInstance(MyProxyView.class.getClassLoader(), interfaces, new MyProxyView());
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {

        //可以拿到方法的参数
        Arrays.stream(args).forEach(System.out::println);

        //这里不需要另外再次调用invoke方法, 就已经可以拿到接口方法了.
        //也可以拿到其他东西.
       /* String methodName = method.getName();
        System.out.println("调用的方法名称为:" + methodName);
        Class<?> returnType = method.getReturnType();
        System.out.println("返回的类型为" + returnType.getName());*/

        //也可以通过注解去取注解上的value
     /*   Annotation parameterAnnotations[][] = method.getParameterAnnotations();
        for (int i = 0; i < parameterAnnotations.length; i++) {
            for (Annotation annotation : parameterAnnotations[i]) {
                if (Param.class.equals(annotation.annotationType())) {
                    Param o= ((Param) annotation);
                    String value = o.value();
                    System.out.println(value);
                }
            }
        }*/

        //最后,把这里拿到的参数和mapper.xml里的sql语句组合,用传统的jdbc执行.这样就可以操作数据库了.
        Object parameters = null;
        return parameters;
    }


}

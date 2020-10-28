package jichu.jdk动态代理;

/**
 * @author gmq
 * @Description
 * @date 2020/10/27
 */
public class JDKTest {
    public static void main(String[] args) throws ClassNotFoundException {
        HelloServicePeoxy helloServicePeoxy = new HelloServicePeoxy();
        HelloService proxy = (HelloService)helloServicePeoxy.bind(new HelloServiceImpl());
        proxy.sayHello("hello");

        //测试接口的类加载器:
        System.out.println("---++++++++++++----");
        /*Class<?> helloService = Class.forName("jichu.jdk动态代理.HelloService");
        ClassLoader classLoader = helloService.getClassLoader();
        System.out.println(classLoader);*/

    }


}

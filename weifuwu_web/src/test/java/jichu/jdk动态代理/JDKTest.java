package jichu.jdk动态代理;

/**
 * @author gmq
 * @Description
 * @date 2020/10/27
 */
public class JDKTest {
    public static void main(String[] args) {
        HelloServicePeoxy helloServicePeoxy = new HelloServicePeoxy();
        HelloService proxy = (HelloService) helloServicePeoxy.bind(new HelloServiceImpl());
        String hello = proxy.sayHello("hello");
        System.out.println("返回值是:" + hello);

    }


}

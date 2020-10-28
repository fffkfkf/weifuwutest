package jichu.jdk动态代理;

/**
 * @author gmq
 * @Description
 * @date 2020/10/27
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        System.out.println("-------"+name);
    }
}

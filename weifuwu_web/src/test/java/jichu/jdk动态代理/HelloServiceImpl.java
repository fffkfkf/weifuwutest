package jichu.jdk动态代理;

/**
 * @author gmq
 * @Description
 * @date 2020/10/27
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        System.out.println("---执行了HelloServiceImpl中的sayHello----"+name);
        return name+"------HelloServiceImpl";
    }
}

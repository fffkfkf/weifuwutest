package jichu.jdk动态代理;

/**
 * @author gmq
 * @Description
 * @date 2020/10/29
 */
public class MybatisExcuteDemoTest {

    /**
     * 类比于我们操作mapper接口:注入接口,执行方法.
     *
     * @param args
     */
    public static void main(String[] args) {
        IExample example = (IExample) MyProxyView.newInstance(new Class[]{IExample.class});
        // 在接口执行的时候就会去调invoke 方法
        example.setName("my example", 9);
        example.setDesc("天气晴朗");

    }
}

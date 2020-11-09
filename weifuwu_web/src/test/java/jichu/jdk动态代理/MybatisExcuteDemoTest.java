package jichu.jdk动态代理;

import com.alibaba.druid.filter.config.ConfigTools;

import java.lang.reflect.Method;

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
    public static void main(String[] args) throws Exception {
       // 这里不需要   IExample  的实现类.
        IExample example = (IExample) MyProxyView.newInstance(new Class[]{IExample.class});
        // 在接口执行的时候就会去调invoke 方法
        example.setName("my example", 9);
        example.setDesc("天气晴朗");

        //Class练习.
        Class[] classes = {IExample.class,IExample.class};
        Class aClass = classes[0];
        Method[] methods = aClass.getMethods();

        String decryptPassword= ConfigTools.decrypt
                ("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJNgolJoIPriP/VrUl4kJAB1HbcRTT5Ep5wdEnPmgjRyK/1IWbTyHpsYCJJ7YTnXVxGvIQbVVkPEkfu7zw58DsUCAwEAAQ==",
                        "FeUnFmfH/43DYQ4C0tEexa1YbFOUFvv62Ke7aAFA+OzJ2JaPOV5yL67KTW7UhQ/lObXqZ3lBoP7hF3k1RD7qfQ==");
        System.out.println("解密后decrypt Password："+decryptPassword);

    }
}

package atguigu.java8.mytest;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author gmq
 * @Description
 * @date 2020/9/22
 */
public class MyJava8Test {

    @Test
    public void test1() {
        List<String> asList = Arrays.asList("2", "9", "3");
        //输出>= 3的数
        eval(asList, n -> Integer.parseInt(n) >= 3);

    }

    private void eval(List<String> list, Predicate<String> predicate) {
        for (String ss : list) {
            if (predicate.test(ss)) {
                System.out.println(ss);
            }
        }
    }

}

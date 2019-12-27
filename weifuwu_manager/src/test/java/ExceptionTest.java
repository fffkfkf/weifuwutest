import org.junit.Test;

import java.util.ArrayList;

/**
 * @author gmq
 * @date 2019/12/22
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */

public class ExceptionTest {
    @Test
    public void test1() {
        getFsmNumById();
        System.out.println("getFsmNumByI后边的------");
        System.out.println("结束了------");
    }

    public int getFsmNumById() {
        ArrayList<String> list = new ArrayList<>();
        //list.get(3);
        return 0;
    }
}

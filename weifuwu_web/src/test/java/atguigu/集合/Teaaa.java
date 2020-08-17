package atguigu.集合;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author gmq
 * @date 2020/8/15
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Teaaa {

    //list下集合的删除
    @Test
    public void test1() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(55);
        list.add(6);
        list.add(3);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(1)) {
                list.remove(i);
                i--;
            }

        }
        System.out.println(list);

    }


}

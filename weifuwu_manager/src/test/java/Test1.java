import org.junit.Test;

import javax.xml.ws.soap.Addressing;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;

/**
 * @author gmq
 * @date 2019/12/24
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Test1 {

    @Test
    public  void maintest() {
        // 模拟随机执行时长
        //int nextInt(int num)         //随机返回一个值在[0,num)的int类型的整数,包括0不包括num
        //System.out.println(new Random().nextInt(5));

        Function<OrderItemNode, Object> function = (node) ->{
            System.out.println(node);
            System.out.println(111);

            /**
             * 处理自身逻辑，存在继承关系
             */
            node.genBeforeCommon();
            /**
             * 生成特殊逻辑，用于二次开发进行扩展的逻辑
             */
            node.genBeforeSpecial();
            return node;
        };

        traversal("11",function);
    }

    public void traversal(String traversalType, Function<OrderItemNode,Object> function){

    }

    @Test
    public void test2(){
        Comparator<Integer> com =(a,b) ->Integer.compare(a,b);
        System.out.println(com);
        TreeSet<Integer> tree=new TreeSet<>(com);
        tree.add(1);
        tree.add(12);
        tree.add(13);
        tree.add(5);
        System.out.println(tree);

        TreeSet<Integer> tree2=new TreeSet<>();
        tree2.add(1);
        tree2.add(12);
        tree2.add(13);
        tree2.add(5);
        System.out.println(tree2);

        List<Integer> objects = new ArrayList<>();
        objects.add(1);
        objects.add(2);
        objects.add(44);
        objects.add(6);

        Collections.sort(objects, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

        Collections.sort(objects,(x,t) -> {
            System.out.println(11);
            return x.compareTo(t);
        });


    }




}

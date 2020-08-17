import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author gmq
 * @date 2020/7/3
 *
 */
public class Aaa {

    @Test
    public void test1() {
        Student student = new Student();
        Student student2 = new Student();
        System.out.println(student.equals(student));    //true
        System.out.println(student.hashCode());            //356573597
        System.out.println(student.hashCode());           //1735600054
        HashMap<Student, String> map = new HashMap<>();
        map.put(student,"123");
        map.put(student,"456");
        System.out.println(map.get(student));
        System.out.println(map.get(student));

        Map concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put(1,12);


        while (true){
            concurrentHashMap.put(1,12);
        }

    }

}

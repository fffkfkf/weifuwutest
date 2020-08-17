import java.util.*;

/**
 * 对的
 *
 * @author
 * @date 2020/6/29
 */
public class Ramdomtest {

    public static void main(String args[]) {

        List<String> list = new ArrayList<String>();
        list.add("123");
        list.add("456");
        Object[] objects = list.toArray();

// array to list
        String[] array = new String[]{"123","456"};
        List<String> strings = Arrays.asList(array);

        Queue queue = new ArrayDeque<Runnable>();
        queue.add(22);
        queue.poll();
        queue.remove();

    }

}






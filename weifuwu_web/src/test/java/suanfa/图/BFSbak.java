package suanfa.图;

import java.util.*;

/**
 * https://www.cnblogs.com/developerY/p/3323264.html
 *
 * @author gmq
 * @Description
 * @date 2020/12/11
 */
public class BFSbak {

    public static void main(String args[]) {
        BFSbak bb = new BFSbak();
// s顶点的邻接表
        LinkedList<Character> list_s = new LinkedList<Character>();
        list_s.add('w');
        list_s.add('r');
        LinkedList<Character> list_w = new LinkedList<Character>();
        list_w.add('s');
        list_w.add('i');
        list_w.add('x');
        LinkedList<Character> list_r = new LinkedList<Character>();
        list_r.add('s');
        list_r.add('v');
        LinkedList<Character> list_x = new LinkedList<Character>();
        list_x.add('w');
        list_x.add('i');
        list_x.add('u');
        list_x.add('y');
        LinkedList<Character> list_v = new LinkedList<Character>();
        list_v.add('r');
        LinkedList<Character> list_i = new LinkedList<Character>();
        list_i.add('u');
        list_i.add('x');
        list_i.add('w');
        LinkedList<Character> list_u = new LinkedList<Character>();
        list_u.add('i');
        list_u.add('x');
        list_u.add('y');
        LinkedList<Character> list_y = new LinkedList<Character>();
        list_y.add('u');
        list_y.add('x');
        HashMap<Character, LinkedList<Character>> graph = new HashMap<Character, LinkedList<Character>>();
        graph.put('s', list_s);
        graph.put('w', list_w);
        graph.put('r', list_r);
        graph.put('x', list_x);
        graph.put('v', list_v);
        graph.put('i', list_i);
        graph.put('y', list_y);
        graph.put('u', list_u);
        HashMap<Character, Integer> dist = new HashMap<Character, Integer>();
        char start = 's';
        // bb.bfs(graph, dist, start);
        System.out.println("---------------");
        bb.bfs22(graph, dist, start);

    }
    /*HashMap<Character,LinkedList<Character>> graph
     * 这个HashMap是用于存放图中每个node的邻接表
     * 表示此映射所维护的键的类型为Character，此映射值的类型为LinkedList<Character>
     * graph 表示将映射关系存放在graph此映射中
     *
     * LinkedList<Character> 表示在此Collection中保持元素类型为Character
     *
     * HashMap<Character,Integer> dist
     * 这个HashMap 是用于存放每个node与距离顶点s的距离的映射关系
     * 表示此映射所维护的键的类型为Character
     * 此映射所维护的值的类型为Integer，dist表示将映射关系存放到dist此映射中
     */

    private void bfs(HashMap<Character, LinkedList<Character>> graph, HashMap<Character, Integer> dist, char start) {
//Queue<Character> 表示在此Collection中所保存的元素的类型为Character
        Queue<Character> q = new LinkedList<Character>();
        q.add(start);//将指定元素s插入队列，成功时返回true，如果没有可用空间，则返回illegalStateException

/*put(start,0) start为指定值将要关联的键，0为指定值将要关联的值，
如果start与0的映射关系已存在，则返回并替换旧值0
如果 start与0的映射关系不存在，则返回null
*/
        dist.put(start, 0);

        int i = 0;
        while (!q.isEmpty())//
        {
            char top = q.poll();//获取并移除队列的头，返回队列的头，如果队列为空，返回null
            i++;

//dist.get(top) 返回指定键top所映射的值
            System.out.println("The " + i + "th element:" + top + " Distance from s is:" + dist.get(top));
            int d = dist.get(top) + 1;//得出其周边还未被访问的节点的距离

/*graph.get(top)如果此映射包含一个满足 (key==null ? k==null : key.equals(k))
的从 k 键到 v 值的映射关系，则此方法返回 v；否则返回 null。（最多只能有一个这样的映射关系。）
for（元素变量：元素集合），如果元素集合中所有元素都已遍历过，则结束此循环，
否则执行for循环里的程序块
*/
            for (Character c : graph.get(top)) {

// containskey(key) 如果此映射包含对于指定键key的映射关系，则返回true
                if (!dist.containsKey(c))//如果dist中还没有该元素说明还没有被访问
                {
/*关联指定键c与指定值d，如果关联关系已存在，则替换旧值d，返回旧值d，
如果无映射关系，则返回null*/
                    dist.put(c, d);
                    q.add(c); //将指定元素c插入队列，成功时返回true，如果没有可用空间，则返回illegalStateException
                }
            }
        }
    }

    private void bfs22(HashMap<Character, LinkedList<Character>> graph,
                       HashMap<Character, Integer> dist, char start) {
        Queue<Character> q = new LinkedList<Character>();
        q.add(start);
        dist.put(start, 0);
        int i = 0;
        while (!q.isEmpty()) {
            char top = q.poll();
            i++;
            System.out.println("The " + i + "th element:"
                    + top + " Distance from s is:" + dist.get(top));
            int d = dist.get(top) + 1;
            for (Character c : graph.get(top)) {
                if (!dist.containsKey(c)) {
                    dist.put(c, d);
                    q.add(c);
                }
            }
        }
    }
}

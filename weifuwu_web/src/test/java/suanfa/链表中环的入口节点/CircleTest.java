package suanfa.链表中环的入口节点;

/**
 * @author gmq
 * @date 2020/8/4
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class CircleTest {

    public static void main(String[] args) {
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);


        listNode2.next=listNode3;
        listNode3.next=listNode2;

        Solution5 solution5 = new Solution5();
        boolean b = solution5.hasCircle(listNode2);
        System.out.println(b);

    }


}

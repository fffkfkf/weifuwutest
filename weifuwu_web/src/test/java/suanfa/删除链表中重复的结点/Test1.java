package suanfa.删除链表中重复的结点;

import org.junit.Test;

/**
 * @author gmq
 * @date 2020/4/19
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Test1 {

    @Test
    public void test1(){
        ListNode listNode = new ListNode(1);
        listNode.next= new ListNode(2);
        listNode.next.next=new ListNode(2);
        listNode.next.next.next=new ListNode(4);

        Solution1 solution1 = new Solution1();
        ListNode listNode1 = solution1.deleteDuplication(listNode);

        System.out.println(listNode1.toString());
    }

}

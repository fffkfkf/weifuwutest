package suanfa.反转链表;

import suanfa.ListNode;

/**
 * todo  这个题不会????????????????????
 * @author gmq
 * @date 2020/8/9
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution {

    public ListNode ReverseList(ListNode head) {
        // 判断链表为空或长度为1的情况
        if(head == null || head.getNext() == null){
            return head;
        }
        ListNode pre = null; // 当前节点的前一个节点
        ListNode next = null; // 当前节点的下一个节点
        while( head != null){
            next = head.getNext(); // 记录当前节点的下一个节点位置；
            head.setNext(pre); // 让当前节点指向前一个节点位置，完成反转
            pre = head; // pre 往右走
            head = next;// 当前节点往右继续走
        }
        return pre;
    }




}

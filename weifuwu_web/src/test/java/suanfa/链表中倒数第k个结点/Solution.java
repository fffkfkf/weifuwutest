package suanfa.链表中倒数第k个结点;

import suanfa.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @author gmq
 * @date 2020/8/17
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution {

    public ListNode FindKthToTail(ListNode head, int k) {
        //
        if (head==null || k<0){
            return null;
        }

        ListNode headTemp = head;
        Integer n = 0;
        while (headTemp != null) {
            n++;
            headTemp = headTemp.getNext();

        }

        if(n<k){
            return null;
        }
        n-=k;
        while ((n--)>0){
            head=head.getNext();
        }

        return head;
    }

    public static void main(String[] args) {




    }

}

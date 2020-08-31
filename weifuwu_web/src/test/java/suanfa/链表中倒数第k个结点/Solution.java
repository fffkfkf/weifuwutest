package suanfa.链表中倒数第k个结点;

import suanfa.ListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * @author gmq
 * @date 2020/8/17
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution {

    //普通解法,求倒数第k个，可以转换成求正数第多少个呢？
    public ListNode FindKthToTail(ListNode head, int k) {

        if (head == null || k <= 0) {
            return null;
        }
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        if (k > n) {
            return null;
        }

        n -= k;
        while ((n--) > 0) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }

    /**
     * 快慢指针
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail2(ListNode head, int k) {

        if (head == null || k <= 0) {
            return null;
        }
        ListNode fast=head;
        ListNode slow=head;
        while ((k--)>0){
            if (fast==null){
                return null;
            }
            fast=fast.next;
        }
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;



    }

}

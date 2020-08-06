package suanfa.删除链表中重复的结点;

import java.util.HashSet;

/**
 * @author gmq
 * @date 2020/4/19
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution {

    public ListNode deleteDuplication(ListNode pHead) {

        HashSet<Integer> set = new HashSet<>();
        ListNode pre = pHead;
        ListNode curr = pHead.next;
        while (pHead != null) {
            if (pre == curr) {
                set.add(pre.val);
            }
            pre = pre.next;
            curr = curr.next;
        }

        ListNode vHead = new ListNode(-1);
        vHead = pHead.next;

        curr = pHead;
        pre = vHead;

        while (curr != null) {
            if (set.contains(curr.val)) {
                curr = curr.next;
                pre.next = curr;
            } else {
                pre = pre.next;
                curr = curr.next;
            }
        }
        return vHead.next;

    }


}

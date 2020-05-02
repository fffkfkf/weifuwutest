package atguigu.suanfa.删除链表中重复的结点;

import java.util.HashSet;
import java.util.Set;

/**
 * @author gmq
 * @date 2020/4/19
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution1 {


    public ListNode deleteDuplication(ListNode pHead) {

        if (pHead == null) {
            return null;
        }
        Set<Integer> set = new HashSet<>();

        ListNode list = pHead;
        while (pHead.next != null) {
            list = pHead.next;
            set.add(pHead.next.val);

        }
        // 先找出相同结点，存入 set

        // 再根据相同节点删除
        // 先删头部
        if (set.contains(pHead.val)) {
            pHead = pHead.next;
        }
        if (pHead == null) {
            return null;
        }
        // 再删中间结点

        ListNode pre = pHead;
        ListNode cur = pHead.next;
        while (cur != null) {
            if (set.contains(cur.val)) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return pHead;
    }

}

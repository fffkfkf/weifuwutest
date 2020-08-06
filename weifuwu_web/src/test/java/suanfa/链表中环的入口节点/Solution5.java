package suanfa.链表中环的入口节点;

/**
 * 变化: 判断一个链表是否是环? 先写主干, 在写分支和校验
 * @author gmq
 * @date 2020/8/4
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution5 {

    public boolean hasCircle(ListNode node) {
        if (node==null){
            return false;
        }

        ListNode slow = node.next;
        if (slow==null){
            return false;
        }
        ListNode fast = node.next.next;
        while (fast != null) {
            if (slow == fast) {
                return true;
            }
            slow=slow.next;
            if (fast.next==null){
                return false;
            }
            fast=fast.next.next;

        }
        return false;

    }

}

package suanfa.链表中环的入口节点;

/**
 *
 * 此处并没有严格按照1,2,3的步骤,因为第一次两个指针相遇的节点处,就是3中先走的n步,假设slow指针走了x步,
 * 那么第一次相遇的时候,fast走了2x步,如果环中有n个节点,则fast比slow多走了n步,即2x-n=x,则x=n,
 * 所以两个指针第一次相遇的节点就是一个指针从链表头走了环中节点个数n步的位置.
 * @author gmq
 * @date 2020/6/28
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Soluton3 {


    public static ListNode solution2(ListNode pHead) {

        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            //如果一快一慢相遇了
            if (fast == slow) {
                fast = pHead;
                //同时移动.
                while (slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                }

                return slow;
            }
        }
        return null;
    }




}

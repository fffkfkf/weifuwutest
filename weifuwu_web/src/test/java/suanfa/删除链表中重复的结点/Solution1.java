package suanfa.删除链表中重复的结点;

import java.util.*;

/**
 * 没有心情写.
 * 题目:
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * 题解:
 * 根据题意，显然如果能够知道重复的值是什么，然后再遍历一次单链表，删除重复值即可。
 * 找重复值的具体步骤：
 * 1.初始化：set<int> st
 * 2. 遍历单链表相邻两个元素，如果相等，就加入到set当中
 * 3. 直到单链表遍历完</int>
 *
 * 删除重复值的具体步骤：
 * 1.初始化：pre指针指向重复值的前一个节点，cur指向当前遍历的节点值
 * 2.遍历单链表当前元素，然后再set中检查，如果是重复值，就删除，pre->next = cur->next
 * 3. 否则，不是重复值，pre = pre->next, cur = cur->next
 * 4. 知道单链表遍历完
 *
 * @author gmq
 * @date 2020/4/19
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution1 {


    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead==null){
            return pHead;
        }
        Set<Integer> set=new HashSet<>();
        ListNode pre=pHead;
        ListNode cur=pHead.next;

        //把重复的放在set里边.
        while (cur!=null){
            if (pre.val==cur.val){
                set.add(pre.val);
            }
            pre=pre.next;
            cur=cur.next;
        }

        //建一个结果值
        ListNode vHead = new ListNode(-1);
        vHead.next=pHead;
        pre=vHead;
        cur=pHead;
        //对参数遍历,找出符合的结果.
        while (cur!=null){
            if (set.contains(cur.val)){
                cur=cur.next;
                pre.next=cur;
            }else {
                pre=pre.next;
                cur=cur.next;
            }
        }

        return vHead.next;

    }

}

package atguigu.suanfa.删除链表中重复的结点;

import java.util.HashSet;

/**
 * 不户走在ois啊回复的卡的洒落看电视疯狂的撒分开看到释放空间都是mkv董事长m\
 *
 * @author gmq
 * @date 2020/4/19
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution {
    /*public ListNode deleteDuplication(ListNode pHead) {
        double d1 = 0, d2 = 0;
        d1++;
        if (d1 == d2) {
            System.out.println(11);
        }

        return null;
    }*/

    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null){
            return  null;
        }
        // 先找出相同结点，存入 set
        HashSet<Integer> set = new HashSet<>();
        ListNode pre = pHead;
        ListNode cur = pHead.next;
        while(cur != null){
            if(cur.val == pre.val){
                set.add(cur.val);
            }
            pre = cur;
            cur = cur.next;
        }
        // 再根据相同节点删除
        // 先删头部
        while(pHead != null && set.contains(pHead.val)){
            pHead = pHead.next;
        }
        if(pHead == null){
            return null;
        }
        // 再删中间结点
        pre = pHead;
        cur = pHead.next;
        while(cur != null){
            if(set.contains(cur.val)){
                pre.next = cur.next;
                cur = cur.next;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return pHead;
    }


}

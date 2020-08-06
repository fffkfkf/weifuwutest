package suanfa.链表中环的入口节点;

/**
 * @author gmq
 * @date 2020/6/28
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution2 {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }

        ListNode meetNode = meetNode(pHead);
        int num = 1;
        ListNode pNode = meetNode;
        while (pNode.next != meetNode) {
            pNode = pNode.next;
            num++;
        }

        //移动的节点.
        pNode = pHead;
        for (int i = 0; i < num; i++) {
            pNode = pNode.next;
        }

        //同时移动
        ListNode pNode1 = pHead;
        while (pNode1 != pNode) {
            pNode1 = pNode1.next;
            pNode = pNode.next;
        }


        return pNode1;
    }
    //找到一快一慢两个指针相遇的节点(环中的一个节点)
//慢节点,入参的下个节点
//快节点,入参的下下个节点
//快指针一次走两步.

    private ListNode meetNode(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode pSlow = pHead.next;
        if (pSlow==null){
            return null;
        }

        ListNode pFast = pSlow.next;

        while (pSlow != null && pFast != null) {
            if (pSlow == pFast) {
                return pFast;
            }
            pSlow = pSlow.next;
            pFast = pFast.next;
            if (pFast != null) {
                pFast = pFast.next;
            }
        }
        return null;
    }

}

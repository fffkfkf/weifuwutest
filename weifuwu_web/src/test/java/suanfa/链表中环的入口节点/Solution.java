package suanfa.链表中环的入口节点;

import java.util.HashSet;

/**
 * @author gmq
 * @date 2020/4/19
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode meetingNode = meetingNode(pHead);
        if (meetingNode == null) {
            return null;
        }
        // 得到环中节点的数目
        int nodeInLoop = 1;
        ListNode pNode1 = meetingNode;
        while (pNode1.next != meetingNode) {
            pNode1 = pNode1.next;
            nodeInLoop++;
        }

        // 先移动pNode, 次数为环中节点的数量
        pNode1 = pHead;
        for (int i = 0; i < nodeInLoop; ++i) {
            pNode1 = pNode1.next;
        }

// 再同时移动pNode1和pNode2, 同时移动的位置就是入口.
        ListNode pNode2 = pHead;
        while (pNode1 != pNode2) {
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }
        return pNode1;

    }


    //找到一快一慢两个指针相遇的节点(环中的一个节点)
    private ListNode meetingNode(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        //慢节点,入参的下个节点
        ListNode pSlow = pHead.next;
        if (pSlow == null) {
            return null;
        }
        //快节点,入参的下下个节点
        ListNode pFast = pSlow.next;

        while (pFast != null && pSlow != null) {
            if (pFast == pSlow) {
                return pFast;
            }
            pSlow = pSlow.next;
            //快指针一次走两步.
            //pFast = pFast.next.next;
            pFast = pFast.next;
            if (pFast!=null){
                pFast=pFast.next;
            }

        }
        return null;
    }


    private void aaa(){
        HashSet<Object> objects = new HashSet<>();
        boolean add = objects.add(1);

    }

}

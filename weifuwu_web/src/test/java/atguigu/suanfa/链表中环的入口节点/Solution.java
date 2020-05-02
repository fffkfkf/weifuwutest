package atguigu.suanfa.链表中环的入口节点;

/**
 * @author gmq
 * @date 2020/4/19
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution {

    /*public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }

        ListNode fast = pHead;
        ListNode slow = pHead;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode slow2 = pHead;
                while (slow2 != slow) {
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow2;
            }
        }
        return null;

    }*/
    //---------
    private ListNode meetingNode(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode pSlow = pHead.next;
        if (pSlow == null) {
            return null;
        }
        ListNode pFast = pSlow.next;
        while (pFast != null && pSlow != null) {
            if (pFast == pSlow) {
                return pFast;
            }
            pSlow = pSlow.next;
            //pFast = pFast.next.next;
            pFast = pFast.next;
            if (pFast!=null){
                pFast=pFast.next;
            }

        }
        return null;
    }

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

        // 先移动pNode, 次数为环中节点的
        pNode1 = pHead;
        for (int i = 0; i < nodeInLoop; ++i) {
            pNode1 = pNode1.next;
        }
// 再移动pNode1和pNode2
        ListNode pNode2 = pHead;
        while (pNode1 != pNode2) {
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }
        return pNode1;

    }


}

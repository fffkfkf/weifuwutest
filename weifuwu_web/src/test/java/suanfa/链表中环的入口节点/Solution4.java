package suanfa.链表中环的入口节点;

import java.util.HashSet;

/**
 * ??????????????
 * @author gmq
 * @date 2020/6/28
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution4 {

    public static ListNode solution1(ListNode pHead) {
        ListNode node = pHead;
        HashSet<ListNode> set = new HashSet<>();
        while (node != null) {
            if (!set.add(node)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

}

package suanfa;

/**
 * @author gmq
 * @date 2020/8/9
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class ListNode {

    public int val;
    public ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}

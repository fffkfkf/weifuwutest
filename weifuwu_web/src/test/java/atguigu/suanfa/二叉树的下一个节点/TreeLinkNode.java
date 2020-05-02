package atguigu.suanfa.二叉树的下一个节点;

/**
 * @author gmq
 * @date 2020/4/25
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class TreeLinkNode {


    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    /**
     * 二叉树存储着指向父结点的指针（next）
     */
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

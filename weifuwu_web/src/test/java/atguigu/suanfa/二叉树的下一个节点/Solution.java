package atguigu.suanfa.二叉树的下一个节点;

import java.util.*;

/**
 * todo 不会呀!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 *既然给了二叉树的某个结点，且二叉树存储着指向父结点的指针（next），
 * 那我们可以先找到根节点，再对树进行中序遍历，最后根据中序遍历结果找到给定结点的下一结点
 * @author gmq
 * @date 2020/4/25
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution {

    static ArrayList<TreeLinkNode> list = new ArrayList<>();

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode par = pNode;
        // 先找到根节点
        while (par.next != null) {
            par = par.next;
        }
        inorder(par);
        for (int i = 0; i < list.size(); i++) {
            if (pNode == list.get(i)) {
                //找到的是否是最后一个节点,是,下个节点就是空.
                return i == list.size() - 1 ? null : list.get(i + 1);
            }
        }

        return null;
    }

    /**
     * 再对树进行中序遍历
     * @param pNode
     */
    private void inorder(TreeLinkNode pNode) {
        if (pNode != null) {
            inorder(pNode.left);
            list.add(pNode);
            inorder(pNode.right);
        }
    }

}

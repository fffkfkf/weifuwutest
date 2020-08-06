package suanfa.二叉搜索树的第k个结点;

import java.util.ArrayList;
import java.util.List;

/**
 * 第二遍刷题
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）
 * 中，按结点数值大小顺序第三小结点的值为4。
 *
 * @author gmq
 * @date 2020/6/15
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution2 {

    List<TreeNode> treeNodes = new ArrayList<>();

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        if (k==0){
            return null;
        }

        inOrder(pRoot);
        if (k>treeNodes.size()){
            return null;
        }

        TreeNode treeNode = treeNodes.get(k-1);
        return treeNode;


    }

    private void inOrder(TreeNode pRoot) {
        if (pRoot.left != null) {
            inOrder(pRoot.left);
        }

        treeNodes.add(pRoot);

        if (pRoot.right != null) {
            inOrder(pRoot.right);
        }

    }


}

package suanfa.输入一棵二叉树求该树的深度;

/**
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * @author gmq
 * @date 2020/2/12
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution {

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        int depth = leftDepth > rightDepth ? leftDepth : rightDepth;

        return depth + 1;
    }

}

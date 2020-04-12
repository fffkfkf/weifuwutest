package atguigu.suanfa.判断该二叉树是否是平衡二叉树;

import atguigu.suanfa.输入一棵二叉树求该树的深度.TreeNode;
import org.apache.poi.ss.formula.functions.Count;

/**
 * @author gmq
 * @date 2020/2/12
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution {

    public boolean IsBalanced_Solution(TreeNode root) {
        int i = countDepth(root);
        return i != -1;
    }

    private int countDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countDepth(root.left);
        if (left == -1) return -1;
        int right = countDepth(root.right);
        if (right == -1) return -1;
        if (left - right < (-1) || left - right > 1) {
            return -1;
        } else {
            return 1 + (left > right ? left : right);
        }
    }


}

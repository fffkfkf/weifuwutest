package atguigu.suanfa.对称的二叉树;

/**
 * 就是按题意先画一棵“大”一点的对称二叉树，然后按树的一层一层比较一下，(左节点是否等于右节点)
 * 看看怎么算是满足对称的二叉树，思路就有了。
 *
 * @author gmq
 * @date 2020/5/1
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        boolean result = judge(pRoot.left, pRoot.right);
        return result;
    }

    private boolean judge(TreeNode left, TreeNode right) {
        // 先判断都是空情况
        if (left == null && right == null) {
            return true;
        }
        //再判断单个
        if (left == null || right == null) {
            return false;
        }


        if (left.val != right.val) {
            return false;
        } else {
            //整个都要判断
            return judge(left.left, right.right) && judge(left.right, right.left);
        }

    }


}
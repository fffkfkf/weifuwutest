package suanfa.对称的二叉树;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * @author gmq
 * @date 2020/6/22
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution2 {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        Boolean result = judge(pRoot.left, pRoot.right);
        return result;
    }

    private Boolean judge(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }else {
            Boolean judge2 = judge(left.left, right.right);
            Boolean judge3 = judge(left.right, right.left);
            return judge2 && judge3;

        }
//        Boolean judge = judge(left.left, left.right);
//        Boolean judge1 = judge(right.left, right.right);
    }

}

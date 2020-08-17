package suanfa;

/**
 * @author gmq
 * @date 2020/8/7
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class TreeNode {
    public int val = 0;
   public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}

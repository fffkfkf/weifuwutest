package atguigu.suanfa.二叉树中和为某一值的路径;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;
import org.mockito.internal.matchers.Find;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 * 重写一个二维数组的排序算法即可，但是我认为这个实现不是这道题目的关键，所以并没有扣这个细节.
 *
 * @author gmq
 * @date 2020/1/23
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution {










    @Test
    public void test1() {
        TreeNode treeNode2l = new TreeNode(1);
        TreeNode treeNode2r = new TreeNode(2);
        TreeNode treeNode2l1 = new TreeNode(1);
        TreeNode treeNode2r2 = new TreeNode(2);

        TreeNode treeNode1l = new TreeNode(2);
        treeNode1l.setLeft(treeNode2l);
        treeNode1l.setRight(treeNode2r);
        TreeNode treeNode1r = new TreeNode(1);
        treeNode1r.setLeft(treeNode2l1);
        treeNode1r.setRight(treeNode2r2);

        TreeNode treeNode0 = new TreeNode(1);
        treeNode0.setLeft(treeNode1l);
        treeNode0.setRight(treeNode1r);


    }



    public class TreeNode {

        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode() {
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

}

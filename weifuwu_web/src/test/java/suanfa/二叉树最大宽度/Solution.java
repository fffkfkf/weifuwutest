package suanfa.二叉树最大宽度;

import suanfa.ConstructTree;
import suanfa.TreeNode;

import java.util.*;

/**
 * -----------不明白.-------------------
 *
 *
 *给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。
 * 这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 *
 *宽度优先搜索顺序遍历每个节点的过程中，我们记录节点的 position 信息，对于每一个深度，
 * 第一个遇到的节点是最左边的节点，最后一个到达的节点是最右边的节点。
 * @author gmq
 * @date 2020/8/6
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
class Solution {
    int ans;//3.创建一个存放结果的变量
    HashMap<Integer, Integer> leftMap;//1.创建一个存最左侧位置的map，其它数据结构也可以。

    public static void main(String[] args) {
        Integer[] nums = {5,4,11,7};
        TreeNode tree = ConstructTree.constructTree(nums);
        Solution solution = new Solution();
        int width = solution.widthOfBinaryTree(tree);
        System.out.println(width);
    }

    public int widthOfBinaryTree(TreeNode root) {
        ans = 0;//4.初始化该全局变量
        leftMap = new HashMap();//2.初始化该全局变量。
        dfs(root, 0, 0);
        return ans;//5.返回结果
    }

    public void dfs(TreeNode root, int depth, int pos) {
        if (root == null) return;//6.递归终止条件。
        //computeIfAbsent, 如果键depth为空,把值pos存入.
        leftMap.computeIfAbsent(depth, x -> pos);//9.添加最左侧的元素，当第一次走到某一层的时候，此时map里面是空，更新一次位置信息。
        ans = Math.max(ans, pos - leftMap.get(depth) + 1);//10.计算当前结点跟最左侧结点位置的距离，并更新最大值。
        dfs(root.getLeft(), depth + 1, 2 * pos);//7.计算左孩子的位置并记录所在层级，在遇到同层级的最左侧元素就可以参与运算得出距离。
        dfs(root.getRight(), depth + 1, 2 * pos + 1);//8.计算左孩子的位置并记录所在层级

    }
}



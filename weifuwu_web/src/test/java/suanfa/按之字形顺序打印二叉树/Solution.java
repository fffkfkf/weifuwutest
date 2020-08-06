package suanfa.按之字形顺序打印二叉树;

import java.util.*;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * @author gmq
 * @date 2020/5/1
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        int level = 1;
        //奇数层
        Stack<TreeNode> s1 = new Stack<>();
        //树放入s1栈中,作为第一层.
        s1.push(pRoot);
        //偶数层
        Stack<TreeNode> s2 = new Stack<>();

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        //循环遍历s1.
        while (!s1.empty() || !s2.empty()) {
            //奇数层:
            if (level % 2 != 0) {
                ArrayList<Integer> temp = new ArrayList<>();
                //遍历奇数层节点
                while (!s1.empty()) {
                    //弹栈
                    TreeNode node = s1.pop();
                    if (node != null) {
                        //放入奇数层的队列中
                        temp.add(node.val);
                        //下一层的节点放入s2栈中
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }

                if (!temp.isEmpty()) {
                    //遍历完之后,将本层的节点放入出参中.
                    lists.add(temp);
                    level++;
                }
            } else {
                //偶数层
                ArrayList<Integer> temp = new ArrayList<>();
                while (!s2.isEmpty()) {
                    TreeNode node = s2.pop();
                    if (node != null) {
                        temp.add(node.val);
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                if (!temp.isEmpty()) {
                    lists.add(temp);
                    level++;
                }

            }

        }
        return lists;

    }


}

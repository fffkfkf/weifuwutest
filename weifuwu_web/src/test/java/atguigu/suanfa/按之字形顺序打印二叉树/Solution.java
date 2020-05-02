package atguigu.suanfa.按之字形顺序打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;

/** 不会做啊!!!!!!!!!!!!!!!!!
 * @author gmq
 * @date 2020/5/1
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        LinkedList<TreeNode> temptList = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        boolean rev = true;
        temptList.add(pRoot);
        while (!temptList.isEmpty()) {
            int size = temptList.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = temptList.poll();
                if (node == null) {
                    continue;
                }
                if (rev) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }
                // 添加
                temptList.offer(node.left);
                temptList.offer(node.right);
            }
            if (list.size() != 0) {
                res.add(list);
            }
            rev = !rev;
        }
        return res;
    }







}

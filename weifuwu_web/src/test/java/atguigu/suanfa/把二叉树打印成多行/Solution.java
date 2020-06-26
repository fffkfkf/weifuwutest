package atguigu.suanfa.把二叉树打印成多行;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * @author gmq
 * @date 2020/5/1
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) {
            return lists;
        }
        bainlishu(pRoot, 0, lists);
        return lists;
    }

    /**
     *
     * @param pRoot
     * @param deep
     * @param lists
     */
    private void bainlishu(TreeNode pRoot, int deep, ArrayList<ArrayList<Integer>> lists) {
        if (pRoot == null) {
            return;
        }
        //[[1], [2, 3]]
        if (deep >= lists.size()) {
            //添加层级的元素, 新加了一层
            ArrayList<Integer> list = new ArrayList<>();
            list.add(pRoot.val);
            lists.add(list);
        } else {
            //在每一层内添加元素.
            ArrayList<Integer> list = lists.get(deep);
            list.add(pRoot.val);
        }
        bainlishu(pRoot.left, deep + 1, lists);
        bainlishu(pRoot.right, deep + 1, lists);
    }

}

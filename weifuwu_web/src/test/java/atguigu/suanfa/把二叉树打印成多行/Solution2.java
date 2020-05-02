package atguigu.suanfa.把二叉树打印成多行;

import java.util.ArrayList;

/**
 * @author gmq
 * @date 2020/5/2
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution2 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) {
            return lists;
        }
        dfs(pRoot, 0, lists);
        return lists;
    }

    private void dfs(TreeNode pRoot, int deep, ArrayList<ArrayList<Integer>> lists) {
        if (pRoot == null) {
            return;
        }

        if (deep >= lists.size()) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(pRoot.val);
            lists.add(list);
        } else {
            ArrayList<Integer> list = lists.get(deep);
            list.add(pRoot.val);
        }
        dfs(pRoot.left, deep + 1, lists);
        dfs(pRoot.right, deep + 1, lists);

    }


}

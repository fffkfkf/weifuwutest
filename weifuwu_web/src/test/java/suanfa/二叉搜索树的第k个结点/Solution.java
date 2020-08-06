package suanfa.二叉搜索树的第k个结点;

import java.util.ArrayList;

/**
 * @author gmq
 * @date 2020/5/2
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Solution {
    ArrayList<TreeNode> list = new ArrayList<>();

    TreeNode KthNode(TreeNode pRoot, int k) {

        inOrder(pRoot);
        if (k>list.size() || k==0 ){
            return null;
        }
        return list.get(k-1);
    }

    private void inOrder(TreeNode pRoot) {
        if (pRoot != null) {
            inOrder(pRoot.left);
            list.add(pRoot);
            inOrder(pRoot.right);
        }


    }

}

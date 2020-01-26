package atguigu.suanfa.二叉搜索树与双向链表;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author gmq
 * @date 2020/1/25
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class P191_ConvertBinarySearchTree {

    public TreeNode convert(TreeNode pRootNode) {
        if (pRootNode == null) {
            return pRootNode;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        convert2(pRootNode, list);
        return convert3(list);


    }

    //遍历list,修改指针
    private TreeNode convert3(ArrayList<TreeNode> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            //这里是链接每个节点的左右指针。
            list.get(i).right = list.get(i + 1);
            list.get(i + 1).left = list.get(i);
        }
        return list.get(0);

    }

    //中序遍历
    private void convert2(TreeNode pRootNode, ArrayList<TreeNode> list) {
        if (pRootNode.left != null) {
            convert2(pRootNode.left, list);
        }
        list.add(pRootNode);
        if (pRootNode.right != null) {
            convert2(pRootNode.right, list);
        }
    }

    @Test
    public void test1() {
        TreeNode treeNode2l = new TreeNode(4);
        TreeNode treeNode2r = new TreeNode(8);
        TreeNode treeNode2l1 = new TreeNode(12);
        TreeNode treeNode2r2 = new TreeNode(26);

        TreeNode treeNode1l = new TreeNode(6);
        treeNode1l.left = treeNode2l;
        treeNode1l.right = treeNode2r;
        TreeNode treeNode1r = new TreeNode(14);
        treeNode1r.left = treeNode2l1;
        treeNode1r.right = treeNode2r2;

        TreeNode treeNode0 = new TreeNode(10);
        treeNode0.left = treeNode1l;
        treeNode0.right = treeNode1r;
        TreeNode convert = convert(treeNode0);
        System.out.println(convert.val);
        System.out.println(convert.right.val);
        System.out.println(convert.right.right.val);
        System.out.println(convert.right.right.right.val);

    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}

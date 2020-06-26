package atguigu.suanfa.把二叉树打印成多行;


import org.junit.Test;

import java.util.ArrayList;

/**
 * @author gmq
 * @date 2020/4/19
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class Test1 {

    @Test
    public void test1(){
        TreeNode listNode = new TreeNode(1);
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(3);
  /*      TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(5);*/
        listNode.left= treeNode;
        listNode.right=treeNode1;
     /*   treeNode.left=treeNode2;
        treeNode.right=treeNode3;*/

        Solution2 solution2 = new Solution2();
        ArrayList<ArrayList<Integer>> print = solution2.Print(listNode);

        System.out.println(print.toString());
        //[[1], [3, 2], [4, 5]]
//        Solution solution1 = new Solution();
//        ArrayList<ArrayList<Integer>> print = solution1.Print(listNode);
//
//        System.out.println(print.toString());

    }

}

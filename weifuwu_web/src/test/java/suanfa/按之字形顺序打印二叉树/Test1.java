package suanfa.按之字形顺序打印二叉树;
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

        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode12 = new TreeNode(3);

        TreeNode treeNode21 = new TreeNode(7);
        TreeNode treeNode22 = new TreeNode(8);
  /*      TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(5);*/
        listNode.left= treeNode1;
        listNode.right=treeNode12;

        treeNode1.left=treeNode21;
        treeNode1.right=treeNode22;

//        Solution solution1 = new Solution();
//        ArrayList<ArrayList<Integer>> print = solution1.Print(listNode);
//        System.out.println(print.toString());
        //[[1], [3, 2], [4, 5]]
        System.out.println("----------------");

        Solution2 solution2 = new Solution2();
        ArrayList<ArrayList<Integer>> print2 = solution2.Print(listNode);
        System.out.println(print2.toString());

    }

}

package suanfa.图;


import java.util.*;

/**
 * @author gmq
 * @Description
 * @date 2020/12/14
 */
public class MyDeepFirstSort {

    public static void main(String[] args) {
        TreeNode head=new TreeNode(1);
        TreeNode second=new TreeNode(2);
        TreeNode three=new TreeNode(3);
        TreeNode four=new TreeNode(4);
        TreeNode five=new TreeNode(5);
        TreeNode six=new TreeNode(6);
        TreeNode seven=new TreeNode(7);

        head.rightNode=three;
        head.leftNode=second;
        second.rightNode=five;
        second.leftNode=four;
        three.rightNode=seven;
        three.leftNode=six;
         new MyDeepFirstSort().bfs(head);
       // myDeepFirstSort.bfs(head);
        //  bfs(head);

        System.out.println();
    }

    //
    public  void bfs(TreeNode nodeHead) {
        if(nodeHead==null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(nodeHead);

        while (queue.peek()!=null) {
            //System.out.println(queue);
            TreeNode node = queue.poll();
            System.out.print(node.data + "-");
            if (nodeHead.leftNode != null) {
                queue.add(node.leftNode);
            }
            if (nodeHead.rightNode != null) {
                queue.add(node.rightNode);
            }
        }
    }

    public  void dfs(TreeNode node) {


    }


}

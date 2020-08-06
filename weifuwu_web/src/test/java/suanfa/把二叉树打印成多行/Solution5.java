package suanfa.把二叉树打印成多行;

import java.util.*;
public class Solution5 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> thelist = new ArrayList<ArrayList<Integer>>();
        if(pRoot==null)return thelist; //这里要求返回thelist而不是null
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(pRoot);
        while(!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<Integer>();
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if(temp.left!=null)queue.offer(temp.left);
                if(temp.right!=null)queue.offer(temp.right);
            }
            thelist.add(list);
        }
        return thelist;
    }

}
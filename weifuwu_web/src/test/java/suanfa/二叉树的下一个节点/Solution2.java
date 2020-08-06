package suanfa.二叉树的下一个节点;

import java.util.*;

//练习
public class Solution2{

    List<TreeLinkNode> lists=new ArrayList<>();
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //中序遍历,保存起来.
        //找到下一个节点
        if (pNode==null){
            return null;
        }

        TreeLinkNode pNode1=pNode;

        while (pNode1.next!=null){
            pNode1=pNode1.next;
        }

        inOrderNode(pNode1);
        for (int i=0;i<lists.size();i++){
            if (lists.get(i)==pNode){

                return  i== lists.size()-1? null: lists.get(i+1);
            }
        }
        return null;

    }

    private void inOrderNode(TreeLinkNode pNode) {
        if (pNode==null){
            return;
        }
        inOrderNode(pNode.left);
        lists.add(pNode);
        inOrderNode(pNode.right);

    }


}
package suanfa.图;

/**
 * @author gmq
 * @Description
 * @date 2020/12/2
 */
public class TreeNode {

    int data;
    TreeNode leftNode;
    TreeNode rightNode;
    public TreeNode() {

    }
    public TreeNode(int d) {
        data=d;
    }

    public TreeNode(TreeNode left,TreeNode right,int d) {
        leftNode=left;
        rightNode=right;
        data=d;
    }



}

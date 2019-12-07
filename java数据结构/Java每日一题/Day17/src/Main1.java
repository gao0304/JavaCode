/**
 * [编程题]二叉树的镜像
 * 链接：https://www.nowcoder.com/questionTerminal/564f4c26aa584921bc75623e48ca3011
 * 来源：牛客网
 *
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */
//方法：前序遍历二叉树的每一个节点，然后完成交换
 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

 public TreeNode(int val) {
    this.val = val;
    }
 }
public class Main1 {
    public void Mirror(TreeNode root) {
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            return;
        }
        //交换左孩子和右孩子
        TreeNode tmp=root.left;
        root.left=root.right;
        root.right=tmp;
        //继续用递归实现
        Mirror(root.left);
        Mirror(root.right);
    }
}

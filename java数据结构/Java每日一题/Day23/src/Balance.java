/**
 * [编程题]二叉树平衡检查
 * 实现一个函数，检查二叉树是否平衡，平衡的定义如下，对于树中的任意一个结点，其两颗子树的高度差不超过1。
 * 给定指向树根结点的指针TreeNode* root，请返回一个bool，代表这棵树是否平衡。
 */

import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
    public class Balance {
       //判断平衡
       public boolean isBalance(TreeNode root) {
         if(root==null){
             return true;
         }
         int left=treeDepth(root.left); //获取左子树的高度
         int right=treeDepth(root.right);//获取右子树的高度
         int diff=left-right;
         if(diff>1||diff<-1){ //对于树中的任意一个结点，其两颗子树的高度差不超过1
             return false;
         }
         return isBalance(root.right)&&isBalance(root.right); //递归先遍历左子树，再遍历右子树
    }
    //获取左右子树高度
    public int treeDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=treeDepth(root.left);
        int right=treeDepth(root.right);
        return (left>right)?(left+1):(right+1);
    }
}

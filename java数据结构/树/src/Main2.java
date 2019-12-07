import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
}
public class Main2 {
    public void postOrderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=null;
        TreeNode prve=null;
        while(cur!=null||stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode top=stack.pop();
        }
    }
}

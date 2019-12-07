import sun.reflect.generics.tree.Tree;
import java.util.*;

/**
 * 二叉树的实现代码    ***一定要熟练运用递归
 * 遍历方式非递归实现时要用到栈
 * 和对象关联用非静态，和类关联用静态
 */
public class TestBinaryTree {
    class TreeNode{
        char val;
        TreeNode left;  //左孩子的引用
        TreeNode right; //右孩子的引用
        public TreeNode(char val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    //根据字符串创建二叉树(先开始是前序遍历)    举例：String  s="ABC##DE#G##F###"
    public int i=0;
    TreeNode creatTestTree(String s){
        //用来遍历字符串
        TreeNode root=null;
        if(s.charAt(i)!='#'){
            root=new TreeNode(s.charAt(i));
            i++;
            root.left=creatTestTree(s);
            root.right=creatTestTree(s);
        }else{
            i++;
        }
        return root;
    }
    // 结点个数（左子树的+右字数的+根=结点个数）
     int getSize(TreeNode root){
        if(root==null){
            return 0;
        }
         return getSize(root.left)+getSize(root.right)+1;
     }
  // 叶子结点个数
    int getLeafSize(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            return 1;
        }
         return getLeafSize(root.left)+getLeafSize(root.right);
    }
     // 第 k 层结点个数
    int getKLevelSize(TreeNode root, int k){
        if(root==null){
            return 0;
        }
        if(k==1){
            return 1;
        }
        k--;
        return getKLevelSize(root.left,k)+getKLevelSize(root.right,k);
    }
   //查找，依次在二叉树的 根、左子树、右子树 中查找 value， 如果找到，返回结点，否则返回 null
    TreeNode find(TreeNode root, char val){
        if(root==null){
            return null;
        }
        if(root.val==val){
            return root;
        }
        TreeNode r=find(root.left,val);
        if(r!=null){  //说明在左子树已经找到了
            return r;
        }
        r=find(root.right,val); //在左边没找到继续在右边找
        if(r!=null){
            return r;
        }
        return null;
    }
    //二叉树的高度（分别求左右子树的高度去最大值然后+1）
    int height(TreeNode root){
        if(root==null){
            return 0;
        }
        else{
            int leftHeight=height(root.left);
            int rightHeight=height(root.right);
            return(leftHeight>rightHeight ? leftHeight:rightHeight)+1;
            /*
             return (height(root.left)>height(root.right) ? height(root.left) : height(root.right))+1;
             可以写成这样，但是非常不建议，因为这样会让递归的次数成平方倍增长，效率低下
             */
            //return x=Math.max(height(root.left),height(root.right))+1;
        }
    }
    //前序遍历(递归实现)
      void binaryTreePrevOrder(TreeNode root){
      if(root==null){
            return;
        }
        System.out.print(root.val+"  ");
        binaryTreePrevOrder(root.left);
        binaryTreePrevOrder(root.right);

    }
    //前序遍历(非递归实现：需要栈)
    void binaryTreePrevOrderNonR(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode>stack=new Stack<>();
        TreeNode cur=root;
        TreeNode top=null; //第二步
        while(cur!=null||!stack.isEmpty()){ //第四步（很难想）
        //这里的!stack.isEmpty() 是为了判断少数情况的，不然会无法遍历完
            while(cur!=null){  //第一步
                stack.push(cur);
                System.out.print(cur.val+"  ");
                cur=cur.left;
            }
            top=stack.pop();  //第三步
            cur=top.right;
        }
    }
    //中序遍历(递归实现)
    void binaryTreeInOrder(TreeNode root){
        if(root==null){
            return;
        }
        binaryTreeInOrder(root.left);
        System.out.print(root.val+"  ");
        binaryTreeInOrder(root.right);
    }
    //中序遍历(非递归实现：需要栈)
    void binaryTreeInOrderNonR(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode>stack=new Stack<>();
        TreeNode cur=root;
        TreeNode top=null;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            top=stack.pop();
            System.out.print(top.val+"  ");
            cur=top.right;
        }
    }
    //后序遍历(递归实现)
    void binaryTreePostOrder(TreeNode root){
        if(root==null){
            return;
        }
        binaryTreePostOrder(root.left);
        binaryTreePostOrder(root.right);
        System.out.print(root.val+"  ");
    }
    //后序遍历(非递归实现：需要栈)   ***最复杂
    void binaryTreePostOrderNonR(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur.right == null || cur.right == prev) {
                //这里cur.right == prev是为了让某些情况下条件能顺利执行
                System.out.print(cur.val + "  ");
                stack.pop();
                prev = cur;  //这里第二次不好想，是为了把上一个打印的结点给记录下来
                cur = null;  //这里第一次不好想 ，让cur不在指向刚刚打印过的结点
            } else {
                cur = cur.right;
            }
        }
    }
    // 层序遍历(运用队列)
    void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null){
            return;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode top=queue.poll();
            System.out.print(top.val+"  ");
            if(top.left!=null){
                queue.offer(top.left);
            }
            if(top.right!=null){
                queue.offer(top.right);
            }
        }
    }
    // 判断一棵树是不是完全二叉树  返回0代表是完全二叉树，返回-1代表不是,只有一个根节点也是完全二叉树
    int isCompleteTree(TreeNode root){
        if(root==null){
            return -1;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur!=null){
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
            else{
                break;
            }
        }
        while(!queue.isEmpty()){
            TreeNode cur=queue.peek();
            if(cur==null){
                queue.poll();
            }
            else{
                return -1;
            }
        }
        return 0;
    }
    //相同的树（用递归大事化小）
    boolean isSameTree(TreeNode p,TreeNode q){
        if((p==null&&q!=null)||(p!=null&&q==null)){  //节点的第一种情况
            return false;
        }
        if(p==null&&q==null){  //节点的第二种情况
            return true;
        }
    if(p.val!=q.val){  //判断节点的数据是否相同
            return false;
        }
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
    //另一个树的子树(用到判断两个相同的树的函数)
    // OJ链接：https://leetcode-cn.com/problems/subtree-of-another-tree/submissions/
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null||t==null){
            return false;
        }
        if(isSameTree(s,t)){
            return true;
        }
        if(isSubtree(s.left,t)){ //判断t是否为s.left的子树    看好了这里是isSubTree
            return true;
        }
        if(isSubtree(s.right,t)){//判断t是否为s.right的子树   看好了这里是isSubTree
            return true;
        }
        return false;
    }
    //平衡二叉树(必须判断所有的子树平衡，不能只判断整树)
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        return (Math.abs(leftHeight-rightHeight)<2)&&isBalanced(root.left)&&isBalanced(root.right);
    }
    //对称二叉树（也叫镜像对称二叉树）
    // OJ链接：https://leetcode-cn.com/problems/symmetric-tree/
    public boolean isSymmetricChild(TreeNode leftTree,TreeNode rightTree){
        if((leftTree==null&&rightTree!=null)||(leftTree!=null&&rightTree==null)){
            return false;
        }// 先判断左树或者是不是有一块为空
        if(leftTree==null&&rightTree==null){
            return true;
        }//判断左树或者右树是不是为空
        return leftTree.val==rightTree.val&&
                isSymmetricChild(leftTree,rightTree.right)&&
                isSymmetricChild(leftTree.right,rightTree.left);
        /**这里判断的是（左树和右树的数据是否相同）&&（递归左树的左子树是不是和右树的右子树对称）
         &&（递归左树的右子树是不是和右树的左子树对称）   如果都进行完了说明是对称的，返回true0
         */
    }
    public boolean isSymmetric(TreeNode root) {
         if(root==null){
             return true;
         }
         return isSymmetricChild(root.left,root.right);
    }
    //根据二叉树创建字符串
    // OJ链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree/
    public void tree2strChild(TreeNode t,StringBuilder sb){
        if(t==null){
            return;
        }
        sb.append(t.val);
        if(t.left==null){
            if(t.right==null){
                return;
            }else{
                sb.append("()");
            }
        }else{
            sb.append("(");
            tree2strChild(t.left,sb);
            sb.append(")");
        }
        if(t.right==null){
            return;
        }else{
            sb.append("(");
            tree2strChild(t.right,sb);
            sb.append(")");
        }
    }
    public String tree2str(TreeNode t) {
         if(t==null){
             return "";
         }
         StringBuilder sb=new StringBuilder();
         return sb.toString();
    }
    //二叉树的最近公共祖先(也叫LCA问题)
    // OJ链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        if(root==p||root==q){  //当p,q不在一个树上时
            return root;
        }
        TreeNode left= lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if((left!=null)&&(right!=null)){  //说明他两在同一个子树上呢
            return root;
        }
        if(left!=null){   //这两个if是防止告诉了一个点
            return left;
        }
        if(right!=null){
            return right;
        }
        return null;  //在这里返回证明告诉的点根本找不到
    }
    //二叉树搜索树转换成排序双向链表(对这棵树进行中序遍历***)
    TreeNode prev=null;//(需要定义在外边，定义在里边的话每次递归的值会发生变化)
    public TreeNode Convent(TreeNode pRootOfTree){
        ConcertChild(pRootOfTree);
        TreeNode head=pRootOfTree;
        while(head!=null&&head.left!=null){
            head=head.right;
        }
        return head;
    }
    public void ConcertChild(TreeNode pCur){
        if(pCur==null){
            return;
        }
        ConcertChild(pCur.left);
        //下边需要把每个节点串联成双向链表
        pCur.left=prev;
        if(prev!=null){
            prev.right=pCur;//记录好下一次要遍历的节点
        }
        prev=pCur;  //记录下一次节点的前驱
        ConcertChild(pCur.right);
    }
    /*
     //根据一棵树的前序遍历与中序遍历构造二叉树。
    // OJ链接:https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    方法：先根据前续遍历左边依次向右开始找根，然后找到其在中序遍历中的位置，此时这个位置的左边就是它的左子树，右边反之
    再然后在中序遍历中先还原它的左子树后还原右子树，以此类推
     */
    private int preindex=0;//(需要定义在外边，定义在里边的话每次递归的值会发生变化)
    public TreeNode buildTree1(int[] preorder,int[] inorder){
        if(preorder.length==0||inorder.length==0){
            return null;
        }
        return buildTreechild(preorder,inorder,0,inorder.length-1);
    }
    private TreeNode buildTreechild(int[] preorder,int[] inorder,int inbegin,int inend){
        //如果没有左树或者是右树
        if(inbegin>inend){
            return null;
        }
        TreeNode root=new TreeNode((char) preorder[preindex]); //这里真实的不应该强转，因为定义类属性val的缘故
        //这里rootindex为中序遍历当中，根节点的下标
        int rootindex=findOfinorder(inorder,preorder[preindex],inbegin,inend);
        preindex++;
        root.left=buildTreechild(preorder,inorder,inbegin,rootindex-1);
        root.right=buildTreechild(preorder,inorder,rootindex+1,inend);
        return root;
    }
    private int findOfinorder(int[] inorder,int val,int inbegin,int inend){
        for(int i=inbegin;i<=inend;i++){
            if(inorder[i]==val){
                return i;
            }
        }
        return -1;
    }
    /*
    根据一棵树的中序遍历与后序遍历构造二叉树。
    Oj链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
    方法：先根据后续遍历右边依次向左开始找根，然后找到其在中序遍历中的位置，此时这个位置的左边就是它的左子树，右边反之
    再然后在中序遍历中先还原它的右子树后还原左子树，以此类推
     */
    private int index=0;//(需要定义在外边，定义在里边的话每次递归的值会发生变化)
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0||inorder.length==0){
            return null;
        }
        index=postorder.length-1;
        return buildTreeChild2(postorder,inorder,0,inorder.length-1);
    }
    private TreeNode buildTreeChild2(int[] postorder,int[] inorder,int inbegin,int inend){
        //如果没有左树或者是右树
        if(inbegin>inend){
            return null;
        }
        TreeNode root=new TreeNode((char) postorder[index]);  //这里真实的不应该强转，因为定义类属性val的缘故
        //这里index为后序遍历当中，根节点的下标
        int rootindex=indexOfTreeNode(inorder,postorder[index],inbegin,inend);
        index--;
        root.right=buildTreeChild2(postorder,inorder,rootindex+1,inend);
        root.left=buildTreeChild2(postorder,inorder,inbegin,rootindex-1);
        return root;
    }
    private int indexOfTreeNode(int[] inorder,int val,int inbegin,int inend){
        for(int i=inbegin;i<=inend;i++){
            if(inorder[i]==val){
                return i;
            }
        }
        return -1;
    }
}



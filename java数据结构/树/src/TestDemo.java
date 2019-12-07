import static java.lang.Thread.sleep;

public class TestDemo {
    public static void  main(String[] args) throws InterruptedException {
        TestBinaryTree testBinaryTree=new TestBinaryTree();
        String str="ABC##DE#G##F###";
        TestBinaryTree.TreeNode root=testBinaryTree.creatTestTree(str);
        testBinaryTree.binaryTreePrevOrder(root);//前序遍历
        System.out.println();
        System.out.println("=====================");
        testBinaryTree.binaryTreePrevOrderNonR(root);//前序遍历(非递归实现)
        System.out.println();
        System.out.println("=====================");
        testBinaryTree.binaryTreeInOrder(root);//中序遍历
        System.out.println();
        System.out.println("=====================");
        testBinaryTree.binaryTreeInOrderNonR(root); //中序遍历(非递归实现)
        System.out.println();
        System.out.println("=====================");
        testBinaryTree.binaryTreePostOrder(root);//后序遍历
        System.out.println();
        System.out.println("=====================");
        testBinaryTree.binaryTreePostOrderNonR(root);//后序遍历(非递归实现)
        System.out.println();
        System.out.println("=====================");// 层序遍历(运用队列)
        testBinaryTree.levelOrderTraversal(root);
        System.out.println();
        System.out.println(testBinaryTree.getSize(root));   // 结点个数
        System.out.println(testBinaryTree.getLeafSize(root));// 叶子结点个数
        System.out.println(testBinaryTree.getKLevelSize(root,3));//第 k 层结点个数
        TestBinaryTree.TreeNode treeNode=testBinaryTree.find(root,'D');
        System.out.println(treeNode.val);
        //查找，依次在二叉树的 根、左子树、右子树 中查找 value， 如果找到，返回结点，否则返回 null
        System.out.println(testBinaryTree.height(root));//二叉树的高度
        System.out.println(testBinaryTree.isCompleteTree(root));
    }
}

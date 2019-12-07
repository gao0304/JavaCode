/*
二叉搜索树具有以下性质：
（1）若他的左子树不为空，则左子树所有节点的值都小于根节点的值
（2）若他的右子树不为空，则右子树所有节点的值都大于根节点的值
 它的左右子树也分别是二叉搜索树
 空树也可以看做是二叉搜索树（二叉排序树）
 对一个二叉搜索树进行中序遍历时你会发现它的结果是有序的
 */
/*
写函数的时候和对象关联的用非static修饰；
           和类相关的用static修饰
 */
public class BinarySearchTree {
    static class Node{
        int key;
        Node left;
        Node right;
        public Node(int key){
            this.key=key;
        }
    }
    private Node root=null;
    //搜索
    public Node search(int key){
        Node cur=root;
        while(cur!=null){
            if(key==cur.key){
                return cur;
            }
            else if(key<cur.key){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        return null;
    }
    //插入
    public boolean insert(int key){
        //1.先处理它是空树的情况
        if(root==null){
            root=new Node(key);
            return true;
        }
        Node cur=root;
        Node parent=null; //记录好双亲节点的位置（因为插的时候）
        //2.找到在哪插
        while(cur!=null){
            if(key==cur.key){
                return false;
            }else if(key<cur.key){
                parent=cur;
                cur=cur.left;
            }else{
                parent=cur;
                cur=cur.right;
            }
        }
        //3.进行插入
        Node node=new Node(key);
        if(key<parent.key){
            parent.left=node;
        }else{
            parent.right=node;
        }
        return true;
    }
    //删除(分为3大类，8种小情况)
    //先找到这个节点所在的位置，然后分情况
    public boolean removeNode(int key){
        Node cur=root;
        Node parent=null;
        while(cur!=null){
            if(key==cur.key){
                remove(parent,cur); //找到，进行删除操作
                return true;
            }else {
                if(key<cur.key){
                    parent=cur;
                    cur=cur.left;
            }else{
                    parent=cur;
                    cur=cur.right;
                }
            }
        }
        return false;
    }
    private void remove(Node parent,Node cur){
        if(cur.left==null){
            //1.cur.left==null(又分为三种情况)
            if(cur==root){
                root=cur.right;
            }else if(cur==parent.left){
                {
                    parent.left=cur.right;
                }
            }else{
                parent.right=cur.right;
            }
        }
            //2.cur.right==null(又分为三种情况)
        else if(cur.right==null){
            if(cur==root){
                root=cur.left;
            }else{
                if(cur==parent.left){
                    parent.left=cur.left;
                }else{
                    parent.right=cur.left;
                }
            }
        }
        /*
        //3.cur.left!=null&&cur.right!=null的情况
        这里使用的是替换法进行删除(随机挑一个的话会让树退化成一个不平衡的树)
        替换法：挑一个左子树中最大的或者右子树中最小的替换要删除的节点，然后删除掉那个节点
         */
        else{
            //这里找的是右边最小的那个数
            Node tmp=cur.right;
            Node tmpParent=cur;
            while(tmp.left!=null){
                tmpParent=tmp;
                tmp=tmp.left;
            }
            cur.key=tmp.key;//把tmp的值赋值给要替换的节点
            //(1)要找的替罪羊是其父亲节点的左边
            if(tmp==tmpParent.left){
                tmpParent.left=tmp.right;
            }else{
                //(2)要找的替罪羊是其父亲节点的右边
                tmpParent.right= tmp.right;
            }
        }
    }
    //中序遍历
    static void preOrder(Node root){
        if(root==null){
            return;
        }
        preOrder(root.left);
        System.out.print(root.key+"  ");
        preOrder(root.right);
    }
    public static void main(String[] args) {
        //测试
        BinarySearchTree tree=new BinarySearchTree();
        int[] keys={0,1,2,3,4,5,6,7,9,10};
        for(int key:keys){
            tree.insert(key);
        }
        preOrder(tree.root);
        System.out.println();
        tree.insert(8);
        preOrder(tree.root);
        System.out.println();
        tree.removeNode(5);
        preOrder(tree.root);
    }
}

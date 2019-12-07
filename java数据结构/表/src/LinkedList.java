class Node {
    //定义属性
    int val;  //某一个节点的数值
    Node next = null; //如果next=null,说明它是最后一个节点

    //构造方法
    Node(int x) {
        this.val = x;
        this.next = null;
    }

    public String toString() {
        return String.format("Node(%d)", val);
    }

    //头插
    public static Node pushFront(Node head, int val) {
        Node node = new Node(val);
        node.next = head;
        return node;
    }

    //尾插
    public static Node pushBack(Node head, int val) {
        Node node = new Node(val);
        Node cur = head;
        if (head == null) {
            return node;//node.next=null;    构造方法中已经做过这一步了
        } else {
            while (cur.next!= null) {
                cur = cur.next;
            }
            cur.next = node;
            //node.next=null;    构造方法中已经做过这一步了
            return head;
        }
    }

    //头删(分情况，空链表，非空)
    public static Node popFront(Node head) {
        if (head == null) {
            System.err.println("空链表无法删除");
            return null;
        }
        // 原来第一个结点，会因为没有引用指向而被回收
        return head.next;
    }
    //尾删(分情况：空链表，只有一个节点，大于一个节点)
    public static Node popBack(Node head){
        if (head == null) {
            System.err.println("空链表无法删除");
            return null;
        }
        if(head.next==null){
            return null;
        }
        Node cur=head;
        while(cur.next.next!=null){
            cur=cur.next;
        }
        cur.next=null;
        return head;
    }

    //反转链表
    public static Node reverseList1(Node head){
        //采用创建一个新链表的方式然后不断的进行头插完成
        Node result=null;
        Node cur=head;
        while(cur!=null){
            Node next=cur.next;
            cur.next=result;
            result=cur;
            cur=next;
        }
        return result;
    }
    /*public static Node reverseList2(Node head) {

    }*/
}
public class LinkedList {
    public static void main(String[] args) {
        Node head=null;
        System.out.print("验证头插");
        head = Node.pushFront(head,1);
        head = Node.pushFront(head,2);
        head = Node.pushFront(head,3);
        print(head);

        System.out.print("验证尾插");
        head=Node.pushBack(head,10);
        head=Node.pushBack(head,11);
        head=Node.pushBack(head,12);
        print(head);

        System.out.print("验证头删");
        head=Node.popFront(head);
        head=Node.popFront(head);
        print(head);

        System.out.print("验证尾删");
        head=Node.popBack(head);
        print(head);

        System.out.print("验证反转链表");
        head=Node.reverseList1(head);
        print(head);
    }
    //打印
    public static void print(Node head){
        Node cur=head;
        while(cur!=null){
            System.out.print(cur+"-->");
            cur=cur.next;
        }
        System.out.println("null");
    }
}
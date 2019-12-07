/*
队列用的是单链表实现的，这样效率会高一些
插入的时候用的是尾插，删除的时候用的是头删
 */
class Node{
    int val;
    Node next;
    Node(int val,Node next){
        this.val=val;
        this.next=next;
    }
    Node(int val){
        this(val,null);
    }
    public String toString(){
        return String.format("(%d)",val);
    }

}
public class Queue {
    private  Node front=null;  //链表的第一个节点
    private Node rear=null;   //链表的最后一个节点
    int size=0;
    //入队列
    public void add(int val){
        Node node=new Node(val);
        if(front==null){
            front=node;
            rear=null;
        }
        else{
            rear.next=node;
        }
        rear=node;
        size++;
    }
    //返回队首元素，并且不出队列
    public int peek(){
        if(size<=0){
            System.err.println("这是一个空队列");
        }
        return front.val;
    }
    //返回队首元素，并且出队列
    public int poll() {
        if (size <= 0) {
            System.err.println("这是一个空队列");
        }
        int val = front.val;
        front = front.next;
        if (front == null) {   //这里是应对链表里只有一个节点的情况
            rear = null;
        }
        size--;
        return val;
    }
    //返回元素的个数
    public int size(){
        return size;
    }
    //判断队列是否为空
    public boolean empty(){
        return size==0;
    }
    //打印
    public void print(){
        System.out.print("<--");
        for(Node cur=front;cur!=null;cur=cur.next){
            System.out.print(cur+"<--");
        }
    }
    //主函数
    public static void main(String[] args) {
       Queue myqueue=new Queue();
        myqueue.add(1);
        myqueue.add(2);
        myqueue.add(3);
        myqueue.add(4);
        myqueue.print();   //  1  2  3  4
        System.out.println();
        System.out.println(myqueue.peek());  //1
        myqueue.print();  //  1  2  3  4
        System.out.println();
        System.out.println(myqueue.poll());  // 1
        myqueue.print();//2  3  4
        System.out.println();
        System.out.println(myqueue.size()); //3
        System.out.println(myqueue.empty()); //false
    }
}

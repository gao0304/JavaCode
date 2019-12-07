import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//Hash的key不是有序的
//这里为了方便，设计的哈希函数是int index=key%array.length;
//hashMap的key是允许为null的
public class HashBucket {
    private static class Node {
        private int key;
        private int value;
        private Node next=null;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private Node[] array;
    private int size;
    private static final double LOAD_FACTOR=0.75;
    //构造方法
    public HashBucket() {
        array = new Node[8];
        size = 0;
    }
    //查找
    public int get(int key){
        int index=key%array.length; //找到其对应数组的下标
        Node head=array[index];
        //然后在那个链表中去找
        for(Node cur=head;cur!=null;cur=cur.next){
            if(key == cur.key){  //表明找到了
                return cur.value;
            }
        }
        return -1;
    }
    //插入
    public int put(int key,int value){
        int index=key%array.length;
        //在链表中查找 key 所在的结点
        for(Node cur=array[index];cur!=null;cur=cur.next){
            if(key==cur.key){//如果找到了，更新
                int oldvalue=cur.value;
                cur.value=value;
                return oldvalue;
            }
        }
        //所有结点都不是 key，插入一个新的结点
        Node node =new Node(key, value);
        node.next=array[index];
        array[index]=node;  //这里为啥不能用head代替array[index]
        size++;
        if(loadfactor()>=LOAD_FACTOR){
            resize();
        }
        return -1;
    }
    //删除
    public int remove(int key){
        int index=key%array.length; //找到其对应数组的下标
        Node head=array[index];
        //如果这里只有一个节点
        if(head!=null&&key==head.key){
            array[index]=array[index].next;
            return head.value;
        }
        //如果这里有很多个节点，且要找的不是第一个节点
        Node prve=null;
        for(Node cur=head;cur!=null;cur=cur.next){
            if(key==cur.key){//如果找到了，更新
                prve.next=cur.next;
                return cur.value;
            }
            prve=cur;
        }
        return -1;
    }
    //计算负载因子的大小
    private double loadfactor(){
        return size*1.0/array.length;
    }
    //减小负载因子，需要重新hash所有的数据
    private void resize(){
        Node[] newArray=new Node[array.length*2];
        for(int i=0;i<array.length;i++){
            Node next;
            for(Node cur=array[i];cur!=null;cur=next){
                next=cur.next;
                int index=cur.key%newArray.length;
                cur.next=newArray[index];
                newArray[index]=cur;
            }
        }
        array=newArray;
    }
}
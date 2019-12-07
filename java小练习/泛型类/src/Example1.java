/**
 * 实现泛型类型的搜索树
 *       关于使用TreeMap要注意的事项:
 *          自定义类型作为TreeMap的K   TreeSet的E
 *          要求：1.类型是compare的
 *               2.构造方法传入comparator
 */
public class Example1<E> {
    private E[] array;
    private int size;

    public Example1(){
        array=(E[])new Object[16];
        size=0;
    }
    public void add(E e){
        array[size++]=e;
    }
}

class MylinkedList<E>{
    //里边的E和外边的长的一样，但是不是同一个意思（意义也不同）
    //因为static修饰的东西里边泛型就会失去效果，但是并不影响里边再次定义泛型
    public static class Node<E>{
        private E value;
        private Node<E> next;

        private Node(E e){
            value=e;
            next=null;
        }
    }
    private Node<E> head;
}
 class HashBucket{
    private static class Node{
        private int key;
        private int val;
        Node next;
    }
    private Node[] array;
    private int size;  //当前数据的个数
    public int put(int key,int value){
        for(Node cur=array[index];cur!=null;cur=cur.next){
            if(key==cur.key){
                int oldValue=value;
                cur.value=value;
                return oldValue;
            }
        }
        Node node=array[index];
        array[index]=node;
        size++;
        return -1;
    }
 }

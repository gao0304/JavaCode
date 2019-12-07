public class GenericsMyLinkedList<E> {
    //要想下边使用静态内部类，则需要内部类再创建出一个泛型来，
    //虽然与下边的都是E,但是他们代表的类型和含义都是不一样的
    public static class Node<E> { //这里的E的作用域仅在这里三行
        private E value;
        private Node<E> next;

        private Node(E e){
            value=e;
            next=null;
        }
    }
    private int size;
    private Node<E> head;

    public GenericsMyLinkedList(){
        head=null;
        size=0;
    }

    //头插
    public void pushFront(E e){
        Node<E> node=new Node<>(e);
        node.next=head;
        head=node;
        size++;
    }
    //尾插
    public void pushBack(E e){
        if(size==0){
            pushFront(e);
            return;
        }
        Node<E> node=new Node<>(e);
        Node<E> cur=head;
        Node last=null;
        while(cur!=null){
            last=cur;
            cur=cur.next;
        }
        last.next=node;
        size++;
    }
}

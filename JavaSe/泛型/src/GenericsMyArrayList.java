import java.util.ArrayList;

public class GenericsMyArrayList<E>{
    private E[] array;
    private int size;

    public GenericsMyArrayList(E[] array, int size) {
        this.array = array;
        this.size = size;
    }

    public GenericsMyArrayList(){
        //注意：泛型类型无法直接创建数组，需要先new一个object出来才行
        array=(E[]) new Object[16];
        size=0;
    }
        //尾插
        public void add(E e){
            array[size++]=e;
        }
       //尾删
        public E remove(){
            E element=array[size-1];
            array[size-1]=null;
            //这里要将引用给置为null,保证对象被释放，源码里边是这么解释的：clear to let GC do its work
            size--;
            return element;
    }
}

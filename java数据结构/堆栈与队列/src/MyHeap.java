import java.lang.reflect.Array;
import java.util.Arrays;

public class MyHeap {
    private int[] elem;
    private int usedSize;

    //private final int DEFAUL_SIZE=10;
    public MyHeap(){
        this.elem=new int[10];
        this.usedSize=0;
    }

    //向下调整
    void adjustDown(int root,int len){
        int parent=root;
        int child=2*parent+1;
        while(child<len){
            if(child+1<len && elem[child]<elem[child+1]){
                child++;
            }
            //此时child肯定是最大值的下标
            if(elem[child]>elem[parent]){
                /*int tmp=elem[child];
                elem[child]=elem[parent];
                elem[parent]=tmp;*/
                swap(elem,child,parent);
                parent=child;
                child=2*parent+1;
            }else{
                break;
            }
        }
    }
    //初始化建立大根堆
    public void initHeap(int[] array){
        for(int i=0;i<array.length;i++){
            this.elem[i]=array[i];
            this.usedSize++;
        }
        //开始调整堆，每一颗子树都需要调整
        for(int i=(elem.length-1-1)/2;i>=0;i--){
            adjustDown(i,elem.length);
        }
    }
    //向上调整，从孩子节点开始调整
    void adjustUp(int child){
        int parent=(child-1)/2;
        while(child>0){
            if(this.elem[parent]<this.elem[child]){
                swap(elem,child,parent);
                child=parent;
                parent=(child-1)/2;
            }
            else{
                break;
            }
        }
    }
    //扩容
    void ensureCapacity(){
        if(this.usedSize==this.elem.length){
            this.elem=Arrays.copyOf(this.elem,2*this.elem.length);
        }
        return;
    }
    //交换
    void swap(int[] elem,int a,int b){
        int tmp=elem[a];
        elem[a]=elem[b];
        elem[b]=tmp;
    }
    //插入item到堆中
    void pushHeap(int item){
        ensureCapacity();
        this.elem[this.usedSize]=item;
        this.usedSize++;
        adjustUp(this.usedSize-1);
    }
    //返回堆顶元素，删除数据元素
    int popHeap(){
        if(usedSize==0){
            System.err.println("堆为空");
        }
       /* int tmp=elem[0];
        elem[0]=elem[this.usedSize-1];
        elem[this.usedSize-1]=tmp;*/
        swap(elem,0,this.usedSize-1);
        this.usedSize--;
        adjustDown(0,this.usedSize);
        return 0;
    }
    //返回堆顶元素，不删除数据元素
    int getHeapTop(){
        if(usedSize==0){
            System.err.println("堆为空");
        }
        return this.elem[0];
    }
    //堆排序
    void HeapSort(){
        int end=this.usedSize-1;
        while(end>0){
            swap(elem,elem[0],elem[end]);
            adjustDown(0,end);
            end--;
        }
    }
    //打印堆
    void show(){
        for(int i=0;i<this.usedSize;i++){
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
}

/*
import java.util.Random;

public class Sort {
    //直接插入排序
    void insertSort(int[] array){
        for(int i=1;i<array.length;i++){
            int key=array[i];
            int j;
            for(j=i-1;j>=0&&array[i]>key;j-=1){
                array[j+1]=array[i];
            }
            array[j+1]=key;
        }
    }
    //希尔排序
    void shell(int[] array){
        int gap=array.length;
        while(true){
            gap=(gap/3)+1;
            insertSortWithGap(array,gap);
            if(gap==1){
                break;
            }
        }
    }
    void insertSortWithGap(int[] array,int gap){
        for(int i=gap;i<array.length;i++){
            int key=array[i];
            int j;
            for(j=i-gap;j>=0&&array[i]>key;j-=gap){
                array[j+gap]=array[i];
            }
            array[j+gap]=key;
        }
    }
    //选择排序
    void selectSort(int[] array){
        for(int i=0;i<=array.length-i;i++){
            int maxIndex=0;
            for(int j=0;j<array.length-i;j++){
                if(array[j]>array[maxIndex]){
                    int t = array[maxIndex];
                    array[maxIndex] = array[array.length - i - 1];
                    array[array.length - i - 1] = t;
                }
            }
        }
    }
    //堆排序
    void createHeapBig(int[] array){

    }
    void shiftDownBig(int[] array, int size, int i){

    }
     void heapSort(int[] array){
        createHeapBig(array);
        for(int i=0;i<array.length-1;i++){
            swap(array,array.length-i-1);
            shiftDownBig(array,0,array.length-i-1);
        }
    }
    //冒泡排序
    void bubble(int[] array){

    }
    //快速排序
    void quickSort(int[] array){
        quickSortInter(array,0,array.length-1);
    }

    private void quickSortInter(int[] array, int left, int right) {
        if(left>=right){
            return;
        }
    }

    //交换
    void swap(int[] array, int i){

    }
    public static void main(String[] args) {
       //程序执行时间
            void testSpeed(){
            Random random =new Random(20190924);
            int[] a=new int[10*10000];
            for(int i=0;i<10*10000;i++){
                a[i]=random.nextInt(10*10000);
            }
            long began=System.nanoTime();
            heapSort(a);
            long end=System.nanoTime();
        }
    }

}
*/




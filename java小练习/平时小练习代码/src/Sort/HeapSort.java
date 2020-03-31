package Sort;

import java.util.Arrays;
/*
堆排序：时间复杂度为O（nlog2n）,空间复杂度O（1），不稳定
 */
public class HeapSort {
    public static void main(String[] args){
        int[] array={1,3,0,5,2,2,42,4};
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void heapSort(int[] array) {
        //1.将无序序列构造成一个大顶堆（想要升序）或者小顶堆（想要降序）
        for(int i=array.length/2-1;i>=0;i--){  //从最后一个叶子节点开始调整
            adjustHeap(array,i,array.length);
        }
        //进行完上边的步骤后，我们的堆已经成为了一个大根堆（此处我们输出的是升序）
        //2.将堆顶元素与末尾的元素进行交换，将最大的元素"沉"到数组（堆）的末端
        //3.重新调整结构，使其满足大根堆，然后继续进行第二步骤，直到整个序列有序
        for(int j=array.length-1;j>0;j--){  //这里的j--就是对arr.length的减1；每次经交换后放到大根堆最后是最大的元素，这个元素将不参与后边的步骤
            swap(array,0,j);
            adjustHeap(array,0,j); /*这里为什么是0呢，第一次将整个数组排成大顶堆的时候就是从后面开始排
            而后面这里从开头开始排是因为我们只变动了堆顶元素和末尾元素，而末尾我们不用去管，就相当于在堆中只变动了堆项元素。
            所以就会造成堆的最顶部顺序是正常的，我们就只需要将堆项元素排到它合适的位置就好了。
            */
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;
    }

    private static void adjustHeap(int[] arr,int i,int length){
        int temp=arr[i]; //先取出当前元素的值，保存在临时变量里
        //开始调整
        //1.k=i*2+1   k是i节点的左子节点
        for(int k=i*2+1;k<length;k=k*2+1){ //k=k*2+1继续它的左子节点
            if(k+1<length&&arr[k]<arr[k+1]){
                k++;//k指向右子节点
            }
            if(arr[k]>temp){
                arr[i]=arr[k];  //把较大的值赋值给当前的节点
                i=k; //i指向K,继续循环比较
            }else{
                break;
            }
        }
        //当for循环结束后，我们已将i为父节点的树的最大值，放在了最顶（这里只是将完成了arr[i]与它子节点的交换,可能还有i的父节点，最顶只是相对说法）
        arr[i]=temp; //将temp的值放到调整后的位置
    }
}

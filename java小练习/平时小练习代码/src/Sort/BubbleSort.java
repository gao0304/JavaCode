package Sort;

import java.util.Arrays;

//冒泡排序：时间复杂度：最好O(n)，最坏O(n^2)，空间复杂度：O(1)，稳定性：稳定
public class BubbleSort {
    public static void main(String[] args){
        int[] array={1,3,0,5,2,2,42,4};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSort(int[] array) {
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-i-1;j++){//每次都要从第一个开始比,最后的不用再比
                if(array[j+1]<array[j]){
                    swap(array,j,j+1);
                }
            }
        }
    }
    private static void swap(int[] array, int i, int j) {
        int tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;
    }
}

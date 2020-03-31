package Sort;

import java.util.Arrays;

/*
选择排序：时间复杂度：O(n^2)，空间复杂度O(1)，不稳定：交换数据时可能会出现跳跃式交换
 */
public class SelectSort {
    public static void main(String[] args){
        int[] array={1,3,0,5,2,2,42,4};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void selectSort(int[] array) {
        for(int i=0;i< array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    swap(array,i,j);
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

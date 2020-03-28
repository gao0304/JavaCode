package Sort;

import java.util.Arrays;

//快速排序（时间复杂度为O（nlogN），空间复杂度为O(n)，稳定性：不稳定）
public class QuickSort {
    public static void quickSort(int[] array){
        quick(array,0,array.length-1);
        System.out.println();
    }

    private static void quick(int[] array, int low, int high) {
        if(low==high){
            return;
        }
        if(high-low+1<=10){ //这里是对快排的优化，不一定是10，视情况而定
            insertSort2(array,low,high);
        }
        takeThreeNumber(array,low,high);//加入三数取中法
        int par=partion(array,low,high);
        //递归左边
        if(par>low+1){
            quick(array,low,par-1);
        }

        //递归右边
        if(par+1<high){
            quick(array,par+1,high);
        }
    }
    public static int partion(int[] array,int low,int high){
        int tmp=array[low];
        while(low<high){
            while((low<high)&&array[high]>=tmp){
                high--;
            }
            if(low==high){
               // array[low]=tmp;
                break;
            }else{
                array[low]=array[high];
            }
            while((low<high)&&array[low]<=tmp){
                low++;
            }
            if(low==high){
                //array[low]=tmp;
                break;
            }else{
                array[high]=array[low];
            }
        }
        array[low]=tmp;
        return low;
    }
    /*三数取中法：让原数组达到array[mid]<=array[low]<=array[high]的效果，这样可以尽可能的让
      数组每次partion将原数组分为两部分，这也是快速排序的核心思想，这样做可以不必让大量的递归调用
      造成栈溢出的情况，能有效防止有序数组进行排列的情况
     */
    public static void takeThreeNumber(int[] array,int low,int high){
        int mid=(low+high)>>>1;
        if(array[mid]>array[low]){
            swap(array,mid,low);
        }
        if(array[mid]>array[high]){
            swap(array,mid,high);
        }
        if(array[low]>array[high]){
            swap(array,low,high);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;
    }
    /*对快速排序继续进行优化，当快排将一大个数组分治成很多个小数组后，小数组内部会越来越接近有序
      结合直接插入排序的特点，在快排进行到一定的时候我们选择用直接插入排序
     */

    public static void insertSort2(int[] array,int low,int high){
        int i=low+1;
        int j;
        int tmp;
        while(i<high+1){//这里i<high+1是因为最开始quick传入high的时候high=array.length-1
            tmp=array[i];
            j=i-1;
            while(j>=low){
                if(array[j]>tmp){ //不写array[j]=tmp可以保证稳定性
                    array[j+1]=array[j];
                    j--;
                }else{
                    break;
                }
            }
            array[j+1]=tmp;
            i++;
        }
    }


    public static void main(String[] args){
        int[] array={1,3,0,5,2,2,42,4};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}

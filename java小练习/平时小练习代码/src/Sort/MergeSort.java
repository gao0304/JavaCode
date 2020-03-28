package Sort;

public class MergeSort {
    public static void mergeSort(int[] array){
        mergeSortInternal(array,0,array.length-1);
    }

    private static void mergeSortInternal(int[] array,int low,int high) {
        if (low+1> high) {  //如果分成了小数组只有一个数就不再分了
            return;
        }
        int mid=(low+high)/2;
        //1.向左递归进行分解
        mergeSortInternal(array,low,mid);
        //2.向右递归进行分解
        mergeSortInternal(array,mid+1,high);
        //3.合并小数组
        merge(array,low,mid,high);
    }

    public static void merge(int[] array,int low,int mid,int high){
        int i=low;
        int j=mid+1;
        int length=high-low+1;
        int[] extra=new int[length];
        int k=0;

        //1.选择小的放进新数组中
        while(i<=mid&&j<=high){
            if(array[i]<=array[j]){
                extra[k]=array[i];
                i++;
                k++;
            }else {
                extra[k]=array[j];
                j++;
                k++;
            }
        }
        //2.将剩余的元素放入新数组中
        while(i<=mid){
            extra[k]=array[i];
            i++;
            k++;
        }
        while(j<=high){
            extra[k]=array[j];
            j++;
            k++;
        }
        //3.将extra的元素拷贝到原数组
        for(int t=0;t<length;t++){
            array[low+t]=extra[t];
        }
    }
}

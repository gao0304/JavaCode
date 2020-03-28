package Sort;

public class InsertSort {
    //直接插入排序（数组越有序，时间复杂度越低，最低为O(n)，稳定性：稳定）
    public static void insertSort1(int[] array){
        int i=1;
        int j;
        int tmp;
        while(i<array.length){
            tmp=array[i];
            j=i-1;
            while(j>=0){
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
}

package Sort;

public class ShellSort {

    //希尔排序：通过分组对插排的优化，时间复杂度：最好O(n)，最坏O(n^2)，空间复杂度：O(1)
    public static void shellSort(int[] array){
        int[] drr={5,3,1}; //暂定分组为5组，3组，1组（最后一次进行直接插入排序）
        for(int i=0;i<drr.length;i++){
            shell(array,drr[i]);
        }
    }

    private static void shell(int[] array, int gap) {
        int i=gap;
        int j;
        int tmp;
        while(i<array.length){
            tmp=array[i];
            j=i-gap;
            while(j>=0){
                if(array[j]>tmp){
                    array[j+gap]=array[j];
                    j=j-gap;
                }else {
                    break;
                }
            }
            array[j+gap]=tmp;
            i++;//通过i++实现对每个组的数据都遍历到，如果写成i=i+gap,则最后一次分组必须是1组
        }
    }
}

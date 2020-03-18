//快速排序
//好的博客文章：https://blog.csdn.net/caofengtao1314/article/details/81978388
public class quickSort {

}
public static void partation(int[] arr){
    int left=arr[0];
    int right=arr[arr.length-1];
    int pivot=arr[0];
    int tmp=pivot;
    while(left<right){
       if(right>=pivot){
           right--;
       }else {
           pivot=right;
           left++;
       }
       if(left<=pivot){

       }
    }
}
}
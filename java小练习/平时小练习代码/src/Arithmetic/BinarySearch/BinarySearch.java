/**
 * 链接：https://www.nowcoder.com/questionTerminal/28d5a9b7fc0b4a078c9a6d59830fb9b9?orderByHotValue=0&commentTags=Java
 * 来源：牛客网
 * 对于一个有序数组，我们通常采用二分查找的方式来定位某一元素，请编写二分查找的算法，在数组中查找指定元素。
 * 给定一个整数数组A及它的大小n，同时给定要查找的元素val，请返回它在数组中的位置(从0开始)，若不存在该元素，返回-1。若该元素出现多次，请返回第一次出现的位置。
 */
package Arithmetic.BinarySearch;

public class BinarySearch {
    //递归版本
    public static void binarySearch(int[] array,int target){
        int left=0;
        int right=array.length-1;
        System.out.println(rec_binarySearch1(array, left, right, target));
    }
    /* 这里输出的时候因为要满足题意若该元素出现多次，请返回第一次出现的位置。
       所以我们要进行判断
       */
    public static int rec_binarySearch1(int[] array,int left,int right,int target){
        int mid=(left+right)>>1;
        if(left>right){
            return -1;
        }
        //第一种：结合它是有序数组排除特殊特殊情况进行判断：这里可能会不太好理解
        if(array[mid]==target&&(mid==left||array[mid-1]!=target)){
            //mid==left结合只有两个一样的数据来想
            //array[mid-1]!=target 结合数组是有序的来想
            return mid;
        }
        if(array[mid]>=target){  //这里是  >=   因为如果不写=的话上边的那个if判断没成功就只能返回-1了
            return rec_binarySearch1(array,left,mid-1,target);
        }else if(array[mid]<target) {
            return rec_binarySearch1(array,mid+1,right,target);
        }
        return -1;
    }
    public static int rec_binarySearch2(int[] array,int left,int right,int target){
        int mid=(left+right)>>1;
        if(left>right){
            return -1;
        }
        if(array[mid]>target){  //这里是  > 因为等于的情况下边会进行处理
            return rec_binarySearch2(array,left,mid-1,target);
        }else if(array[mid]<target) {
            return rec_binarySearch2(array,mid+1,right,target);
        }
        //第二种：如果出现多次target，遍历一下数组a获得第一个value的数组下标返回即可
        for(int i=0;i<array.length;i++){
            if(array[i]==target){
                return i;
            }
        }
        return -1;
    }
    //迭代版本
    public static int ite_binarySearch(int[] array,int target){
        int left=0;
        int right=array.length-1;
        while(left<=right){ //这里要有= ,否则（如果恰好这里有我们要返回的数据），错过了left==right这里会直接返回-1
            int mid=(left+right)>>1;
            if(array[mid]==target&&(mid==left||array[mid-1]!=target)){
                return mid;
            }else if(array[mid]>=target){
                right=mid-1;  //说明想要的数在array[mid]的左边（array是个升序数组）
            }else{
                left=mid+1; //说明想要的数在array[mid]的右边（array是个升序数组）
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] array={4,4,10,21};
        //binarySearch(array,4);
        System.out.println(ite_binarySearch(array,4));
    }
}


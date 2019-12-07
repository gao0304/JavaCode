
/**
 问题：输入一个字符串，输出这个字符串所有可能的字符排列组合的字符串
 方法：我们的想法是每次都把一个数固定在前面，让后面的数递归地进行全排列，这样每个数都固定过以后就能找出所有排列。
 关键的地方在于，我们把每个数固定在前面并让后面的进行全排列完毕以后，要恢复原来的状态，也就需要交换回来。
 */
import java.util.Scanner;
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        help(s);
    }

    private static void help(String s) {
        char[] arr=new char[s.length()];
        int n=s.length();
        for(int i=0;i<n;i++){
            arr[i]=s.charAt(i);
        }
        int beginIndex=0;
        sort(n,arr,beginIndex);
    }

    private static void sort(int n, char[] arr, int beginIndex) {
        if(beginIndex==n-1){//此时只剩下一个元素，不用再交换了
            System.out.println(arr);
        }
        for(int i=beginIndex;i<n;i++){
            swap(arr,i,beginIndex);//交换它和它的下一个元素（包括它本身）
            sort(n,arr,beginIndex+1);//递归求后边的字符排列
            swap(arr,i,beginIndex);//恢复到上一步状态继续进行新的排列（关键）
        }
    }

    //交换函数
    private static void swap(char[] arr, int i, int beginIndex) {
        char tmp=arr[i];
        arr[i]=arr[beginIndex];
        arr[beginIndex]=tmp;
    }
}




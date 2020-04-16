package Others;

import java.util.Scanner;
public class Main1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int[] arr=new int[2*n];
            int[] arr1=new int[n];
            int[] arr2=new int[n];
            int j=0;
            for(int i=0;i<arr1.length;i++){
                arr1[i]=sc.nextInt();
                arr[j]=arr1[i];
                j++;
            }
            for(int i=0;i<arr2.length;i++){
                arr2[i]=sc.nextInt();
                arr[j]=arr2[i];
                j++;
            }

            quickSort(arr);
            if(arr.length%2==0){
                System.out.println(arr[n-1]);
            }else{
                System.out.println(arr[n/2]);
            }
        }
    }
    public static void quickSort(int[] array){
        quick(array,0,array.length-1);
        System.out.println();
    }

    private static void quick(int[] array, int low, int high) {
        if(low==high){
            return;
        }


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
}

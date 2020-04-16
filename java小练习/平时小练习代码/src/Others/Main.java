package Others;

import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int[] arr=new int[2*n];
            int[] arr1=new int[n];
            int[] arr2=new int[n];

            for(int i=0;i<arr1.length;i++){
                arr1[i]=sc.nextInt();

            }
            for(int i=0;i<arr2.length;i++){
                arr2[i]=sc.nextInt();

            }

            int x=0;
            int j=0;
            int p=0;
            while(j<n&&p<n){
                if(arr1[j]<=arr2[p]){
                    arr[x]=arr1[j];
                    j++;
                }else{
                    arr[x]=arr2[p];
                    p++;
                }
                x++;
            }
            if(j==n){
                for(;x<arr.length;x++){
                    arr[x]=arr2[p++];
                }
            }
            if(p==n){
                for(;x<arr.length;x++){
                    arr[x]=arr2[j++];
                }
            }
            if(arr.length%2==0){
                System.out.println(arr[n-1]);
            }else{
                System.out.println(arr[n/2]);
            }
        }
    }

}
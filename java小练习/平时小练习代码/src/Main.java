import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int m=sc.nextInt();
            int[] arr=new int[m];
            for(int i=0;i<m;i++){
                arr[i]=sc.nextInt();
            }
            int[] arr2=new int[m];
            for(int i=0;i<m-1;i++){
                arr2[i]=arr[i+1]-arr[i];
            }
            //int[] arr3=new int[m-2];
            for(int i=0;i<m-1;i++){
                if(arr2[i]<=0){
                    System.out.println(-1);
                    return;
                }
            }
            int tmp=0;
            for(int i=0;i<arr2.length-2;i++){
                tmp=fun(arr2[i],arr2[i+1]);
                arr2[i+1]=tmp;
            }
            if(tmp==0){
                System.out.println(-1);
            }else{
                System.out.println(tmp);
            }
        }
    }
    public static int fun(int n1,int n2){
        int temp;
        while(n2>0){
            temp=n1%n2;
            n1=n2;
            n2=temp;
        }
        return n1;
    }
}

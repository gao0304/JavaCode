import java.util.Scanner;

public class Main1 {
    static int count=0;
    static int[] arr;
    static int n;
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            n=input.nextInt();
            int x=input.nextInt();
            arr=new int[n+1];
            for(int i=1;i<=n;i++){
                arr[i]=input.nextInt();
            }
            count(x,n);
            System.out.println(count);
        }
    }

    private static void count(int x, int n) {
        if(x==0){
            count++;
        }
        if(x<=0||(x>0&&n<0)){
            return;
        }
        count(x-arr[n],n-1);
        count(x,n-1);
    }
}

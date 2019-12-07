//输出一个数的二进制数
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size=32;
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = n % 2;
            n/=2;
            if (n == 0) {
                break;
            }
        }
        boolean flag=false;
        for(int i =arr.length-1; i>=0; i--){
            if(arr[i]!=0){
                flag=true;
            }
            if(flag){
                System.out.print(arr[i]);
            }
        }
    }
}

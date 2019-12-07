
import java.util.*;

public class GrayCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getGray(n));
    }
    public static String[] getGray(int n) {
        int size=32;
        int[] arr = new int[size];
        int[] arr2 = new int[size];
        arr2[0] = arr[0];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = n % 2;
            n /= 2;
            if (n == 0) {
                break;
            }
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = arr2.length - 1; j >= 0; j--) {
                arr2[i] = arr[i + 1] ^ arr[i];
            }
        }
        String[] s=new String[32];
        for(int i = arr2.length - 1; i >= 0; i--){
            for(int j=0;j<s.length;j++){
                s[j]= String.valueOf(arr2[i]);
            }
        }
        return s;
    }
}
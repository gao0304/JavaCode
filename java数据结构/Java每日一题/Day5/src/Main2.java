import java.util.Scanner;

public class Main2 {
    static int[] a = new int[30];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 1;i<= n ; i++){
            a[i] = sc.nextInt();
        }
        System.out.println(count(n,40));
    }
    public static int count(int k , int sum){
        if(sum == 0){
            return 1;   //找到一组和为sum的组合数
        }
        if(k<=0){
            return 0;
        }
        return count(k-1,sum-a[k])+count(k-1,sum);
    }
}
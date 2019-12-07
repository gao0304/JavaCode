import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(fun(n));

    }
    private static int fun(int n) {
        int count=0;
        while(count<100_000){
            if(n%1_000_000_007==0){
                return count;
            }
            fun2(n*32+31,count);
            if((n*4+3)%1_000_000_007==0){
                return count+1;
            }
            fun2(n*128+127,count);
            if(((n*16+15)%1_000_000_007==0)){
                return count+1;
            }
            if(fun2(n,count)){
                return count+1;
            }else fun2(n,count);
        }
        return -1;
    }

    private static boolean fun2(int n, int count) {
        if(n%1_000_000_007==0){
            count++;
            return true;
        }
        return false;
    }
}
/**
 *  while(num<100_000){
 *             if(n1%1_000_000_007==0||n2%1_000_000_007==0){
 *                 return count;
 *             }
 *             n1=4*n+3;
 *             n2=8*n+7;
 *             count++;
 *             num++;
 *         }
 *         return -1;
 */

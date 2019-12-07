/**
 * [编程题]另类加法
 * 请编写一个函数，将两个数字相加。不得使用+或其他算数运算符。
 *
 * 给定两个int A和B。请返回A＋B的值
 *
 * 测试样例：
 * 1,2
 * 返回：3
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       /* Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println(addAB(a,b));*/
       long  a=4*300000001;
       System.out.println(a);
    }

    private static int addAB(int a, int b) {
        int c=(a|b)+(a&b);  //暂时没想到原理，瞎碰哈哈
        return c;
    }
}

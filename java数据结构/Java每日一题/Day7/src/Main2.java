/**
 * [编程题]求最小公倍数
 * 链接：https://www.nowcoder.com/questionTerminal/22948c2cad484e0291350abad86136c3
 * 来源：牛客网
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 * 输入描述:
 * 输入两个正整数A和B。
 *
 * 输出描述:
 * 输出A和B的最小公倍数。
 *
 * 示例1
 * 输入
 * 5 7
 * 输出
 * 35
 */
//最小公倍数 = 两数之积除以最大公约数
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int a=input.nextInt();
        int b=input.nextInt();
        int n=(a*b)/gcd(a,b);
        System.out.println(n);
    }
    private static int gcd(int a, int b) {
/**
 * 求最大公约数：辗转相除法
 * 1\. a%b，令r为所得余数（0≤r<b） 若r=0，算法结束，a即为答案
 * 2\. 互换：置 a←b，b←r，并返回第一步
 */
       if(b==0){
           return a;
       }
       return gcd(b,a%b);
    }
}

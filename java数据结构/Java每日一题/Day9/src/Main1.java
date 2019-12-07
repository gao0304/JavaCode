/**
 * [编程题]末尾0的个数
 * 链接：https://www.nowcoder.com/questionTerminal/6ffdd7e4197c403e88c6a8aa3e7a332a
 * 来源：牛客网
 *
 * 输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
 *
 * 输入描述:
 * 输入为一行，n(1 ≤ n ≤ 1000)
 *
 *
 * 输出描述:
 * 输出一个整数,即题目所求
 * 示例1
 * 输入
 * 10
 * 输出
 * 2
 */
//方法1：时间复杂度太大了，不建议这么写
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        long m=factorial(n);
        //第二步：每次除以10让他少一个0
        int x=0;
        while(m%10==0){
            m/=10;
            x++;
        }
        System.out.println(x);
    }
    //第一步：先算出输入的那个数的阶乘
    private static long factorial(int n) {
        long count=1;
        while(n>=1){
            count*=n;
            n--;
        }
        return count;
    }
}

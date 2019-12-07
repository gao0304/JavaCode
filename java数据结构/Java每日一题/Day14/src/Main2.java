/**
 *[编程题]尼科彻斯定理
 * 链接：https://www.nowcoder.com/questionTerminal/dbace3a5b3c4480e86ee3277f3fe1e85?toCommentId=4994730
 * 来源：牛客网
 *
 * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 *
 * 例如：
 *
 * 1^3=1
 *
 * 2^3=3+5
 *
 * 3^3=7+9+11
 *
 * 4^3=13+15+17+19
 *
 * 接口说明
 *
 * 原型：
 *  /*
 *  功能: 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 *  原型：
 *      int GetSequeOddNum(int m,char * pcSequeOddNum);
 *  输入参数：
 *      int m：整数(取值范围：1～100)
 *
 *  返回值：
 *      m个连续奇数(格式：“7+9+11”);
 *
 *
         *public String GetSequeOddNum(int m)
        *{
        *  //在这里实现功能
        *return null;
        *}
        *
        *输入描述:
        *输入一个int整数
        *
        *输出描述:
        *输出分解后的string
 */
/**
 * 由题可得：假设我们要求出的第一个值为tmp3(是由tmp强制转换为int得到的)，
 * n*tmp=n^3-(2(n-1)+2(n-2)+2(n-3)+...+2*1)
 */

import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(GetSequeOddNum(n));
    }
    private static String GetSequeOddNum(int n) {
        String s="";
        double tmp;
        double tmp2=0.0;
        for(double i=n-1;i>=1;i--){
            tmp2+=2*i;
        }
        tmp=(Math.pow(n,3.0)-tmp2)/n;
        int tmp3=(int)tmp;
        int x=0;
        for(int i=0;i<n;i++){
            s=s+tmp3;
            if(x<n-1){
                s=s+"+";
                x++;
            }
            tmp3+=2;
        }
        return s;
    }
}

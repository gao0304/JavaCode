/**
 * [编程题]数字颠倒
 * 链接：https://www.nowcoder.com/questionTerminal/ae809795fca34687a48b172186e3dafe?orderByHotValue=1&commentTags=Java
 * 来源：牛客网
 * 描述：
 *
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 *
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 *
 * 输入描述:
 * 输入一个int整数
 *
 * 输出描述:
 * 将这个整数以字符串的形式逆序输出
 *
 * 示例1
 * 输入
 * 1516000
 * 输出
 * 0006151
 */

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String n=input.nextLine();
        System.out.println(fun1(n));
        int m=input.nextInt();
    }

    //方法1：用StringBuffer的reverse用法最简单粗暴
    private static StringBuffer fun1(String n) {
        StringBuffer s=new StringBuffer(n);
        return s.reverse();
    }
    //方法2：利用String的charAt方法把字符串转换成一个个字符然后逆序输出
    private static void fun2(int m) {
        String str=""+m; //把数字转换为字符串（简单粗暴）
        for(int i=0;i<=str.length()-1;i--){
            System.out.print(str.charAt(i));//逆序依次输出
        }
    }
}

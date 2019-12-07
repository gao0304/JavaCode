/**
 * [编程题]超长正整数相加
 * 链接：https://www.nowcoder.com/questionTerminal/5821836e0ec140c1aa29510fd05f45fc?f=discussion
 * 来源：牛客网
 *
 * 请设计一个算法完成两个超长正整数的加法。
 *
 * 接口说明
 *
 *  请设计一个算法完成两个超长正整数的加法。
 *  输入参数：
 *  String addend：加数
 *  String augend：被加数
 *  返回值：加法结果
 *
        *public String AddLongInteger(String addend,String augend)
        *{
        *   //在这里实现功能
        *   return null;
        *}
        *输入描述:
        *输入两个字符串数字
        *
        *输出描述:
        *输出相加后的结果，string型
        *
        *示例1
        *输入
        *99999999999999999999999999999999999999999999999999
        *1
        *输出
        *100000000000000000000000000000000000000000000000000
 */
//这里a=b+c

import java.util.Scanner;
public class AddLongInteger {
    public static StringBuffer Add(String b, String c)
    {
        int i;
        StringBuffer a=new StringBuffer("");
        int[] a_int=new int[1000];  //存储字符串b+c的数字
        int[] b_int=new int[1000];  //存储字符串b的数字
        int[] c_int=new int[1000];  //存储字符串c的数字
        for(i=0;i<b.length();i++){
            b_int[i]=b.charAt(b.length()-1-i)-'0';  //减去字符0巧妙的把字符换成对应的数字
        }
        for(i=0;i<c.length();i++){
            c_int[i]=c.charAt(c.length()-1-i)-'0';
        }
        int len=b.length()>c.length()?b.length():c.length(); //len为字符串bc中较长的那个的长度
        for(i=0;i<len;i++){
           a_int[i]+=b_int[i]+c_int[i];
            if (a_int[i]>9)
            {
                //实现竖式加法
                a_int[i + 1] = a_int[i] / 10; //满10进1
                a_int[i] = a_int[i] % 10;  //本来的位置为-10的值
            }
        }
        for(i=a_int.length-1;i>=0;i--){ //倒序放入字符串a中
            a.append(a_int[i]);
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String b=input.next();
        String c=input.next();
        StringBuffer x=Add(b,c);
        //因为这里在定义bc的长度是1000，所以可能会有很多个无用的0出现，输出的时候必须屏蔽
        Boolean flag=false; //定义一个标识flag
        for(int i=0;i<x.length();i++){
            if(x.charAt(i)-'0'!=0){
                flag=true;
            }
            //因为最前边都是无用的0，当出现第一个不为0的数字时开始输出
            if(flag){
                System.out.print(x.charAt(i));
            }
        }
    }
}

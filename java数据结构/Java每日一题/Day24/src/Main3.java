/**
 * [编程题]最高分是多少
 * 链接：https://www.nowcoder.com/questionTerminal/3897c2bcc87943ed98d8e0b9e18c4666
 * 来源：牛客网
 *
 * 老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问。当然，老师有时候需要更新某位同学的成绩.
 *
 * 输入描述:
 * 输入包括多组测试数据。
 * 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
 * 学生ID编号从1编到N。
 * 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
 * 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
 * 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
 *
 * 输出描述:
 * 对于每一次询问操作，在一行里面输出最高成绩.
 * 示例1
 * 输入
 * 5 7
 * 1 2 3 4 5
 * Q 1 5
 * U 3 6
 * Q 3 4
 * Q 4 5
 * U 4 5
 * U 2 9
 * Q 1 5
 * 输出
 * 5
 * 6
 * 5
 * 9
 */

/**
 * 说下此题的坑：
 *    1.不止一组m,n，有多组数据
 *    2.题目中告诉你学生的编号是从1到N，数组中的下标是0到N-1
 *    3.下边的输入a可能会大于b
 * 还有为什么不用字符串表示下边的操作指令，因为可能有几十个人，按字符串的下标索引无法进行操作
 */

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();//学生的数目
            int m=sc.nextInt();//操作数目
            int[] arr=new int[n];// 保存学生成绩
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            // 进行成绩的修改与查询操作
            for(int i=0;sc.hasNext()&&i<m;i++){
                // 在这里由于Scanner中没有nextChar操作，所以先将这个字符串转为字符数组
                char[] c=sc.next().toCharArray();
                int a=sc.nextInt();
                int b=sc.nextInt();
                operate(arr,c,a,b); //进行操作
            }
        }
    }
    private static void operate(int[] arr,char[] c,int a,int b){
        if(c[0]=='Q'){
            // 可能出现所输入编号a,b不确定二者之间的大小
            int begin=(a<b?a:b)-1; //下标比编号少1
            int end=a>b?a:b; //最后的下标取ab的较大值
            int maxNumber=0;// 用于记录最大成绩
            for(int i=begin;i<end;i++){
                if(arr[i]>maxNumber){
                    maxNumber=arr[i];
                }
            }
            System.out.println(maxNumber);
        }
        if(c[0]=='U'){
            arr[a-1]=b;
        }
    }
}

/**
 * [编程题]计算糖果
 * 链接：https://www.nowcoder.com/questionTerminal/02d8d42b197646a5bbd0a98785bb3a34
 * 来源：牛客网
 *
 * A,B,C三个人是好朋友,每个人手里都有一些糖果,我们不知道他们每个人手上具体有多少个糖果,但是我们知道以下的信息：
 * A - B, B - C, A + B, B + C. 这四个数值.每个字母代表每个人所拥有的糖果数.
 * 现在需要通过这四个数值计算出每个人手里有多少个糖果,即A,B,C。这里保证最多只有一组整数A,B,C满足所有题设条件。
 *
 * 输入描述:
 * 输入为一行，一共4个整数，分别为A - B，B - C，A + B，B + C，用空格隔开。 范围均在-30到30之间(闭区间)。
 *
 * 输出描述:
 * 输出为一行，如果存在满足的整数A，B，C则按顺序输出A，B，C，用空格隔开，行末无空格。 如果不存在这样的整数A，B，C，则输出No
 * 示例1
 * 输入
 * 1 -2 3 4
 * 输出
 * 2 1 3
 */
import java.util.Scanner;

public class Main1{
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n1=input.nextInt();
        int n2=input.nextInt();
        int n3=input.nextInt();
        int n4=input.nextInt();
        fun(n1,n2,n3,n4);
    }
    public static void fun(int n1,int n2,int n3,int n4){
        int a,c,b;
        a=(n1+n3)/2;
        b=n3-a;
        c=n4-b;
        //一定要防止无解的情况(abc都是整数且观察得n1+n3一定是偶数)
        if((n1+n3)%2==0&&a>=0&&b>=0&&c>=0){
            System.out.print(a+" ");
            System.out.print(b+" ");
            System.out.print(c);
        }else {
            System.out.println("No");
        }
    }
}


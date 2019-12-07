/**
 *[编程题]数字分类 (20)
 * 链接：https://www.nowcoder.com/questionTerminal/473c219f9e4d4ab2851ed388895a9c86
 * 来源：牛客网
 *
 * 给定一系列正整数，请按要求对数字进行分类，并输出以下5个数字：
 *
 * A1 = 能被5整除的数字中所有偶数的和；
 *
 * A2 = 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；
 *
 * A3 = 被5除后余2的数字的个数；
 *
 * A4 = 被5除后余3的数字的平均数，精确到小数点后1位；
 *
 * A5 = 被5除后余4的数字中最大数字。
 *
 * 输入描述:
 * 每个输入包含1个测试用例。每个测试用例先给出一个不超过1000的正整数N，随后给出N个不超过1000的待分类的正整数。数字间以空格分隔。
 *
 * 输出描述:
 * 对给定的N个正整数，按题目要求计算A1~A5并在一行中顺序输出。数字间以空格分隔，但行末不得有多余空格。
 * 若其中某一类数字不存在，则在相应位置输出“N”。
 * 示例1
 * 输入
 * 13 1 2 3 4 5 6 7 8 9 10 20 16 18
 * 输出
 * 30 11 2 9.7 9
 */
//这道题只需要遍历一遍数组计算A1-A5即可，不用遍历一次计算一次
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int A1=0,A2=0,A3=0,A5=0;
        double A4=0.0;
        int flag=1,count=0; //flag是为了方便计算A2，count是为了方便计算A4
        for(int i=0;i<n;i++){
            //A1= 能被5整除的数字中所有偶数的和；
            if(arr[i]%10==0){
                A1+=arr[i];
            }
            //A2= 将被5除后余1的数字按给出顺序进行交错求和，即计算n1-n2+n3-n4...；
            if(arr[i]%5==1){
                A2+=flag*arr[i];
                flag=-flag;
            }
            //A3= 被5除后余2的数字的个数；
            if(arr[i]%5==2){
                A3++;
            }
            //A4= 被5除后余3的数字的平均数，精确到小数点后1位；
            if(arr[i]%5==3){
                A4+=arr[i];
                count++;
            }
            //A5= 被5除后余4的数字中最大数字。
            if(arr[i]%5==4){
                if(A5<arr[i]){
                    A5=arr[i];
                }
            }
        }
        //按照题目上的要求输出即可
        if(A1!=0){
            System.out.print(A1+" ");
        } else{
            System.out.print('N'+" ");
        }
        if(A2!=0){
            System.out.print(A2+" ");
        } else{
            System.out.print('N'+" ");
        }
        if(A3!=0){System.out.print(A3+" ");
        } else{
            System.out.print('N'+" ");
        }
        if(A4!=0){
            System.out.printf("%.1f ",A4/count);
        } else{
            System.out.print("N"+" ");
        }
        if(A5!=0){
            System.out.print(A5);
        } else{
            System.out.print("N");
        }
    }
}

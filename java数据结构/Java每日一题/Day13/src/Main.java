/**
 * [编程题]跟奥巴马一起编程(15)
 * 链接：https://www.nowcoder.com/questionTerminal/8af708723b0f45f9a80bc80d78d3566e?toCommentId=4986582
 * 来源：牛客网
 *
 * 输入描述:
 * 输入在一行中给出正方形边长N（3<=N<=20）和组成正方形边的某种字符C，间隔一个空格。
 * 输出描述:
 * 输出由给定字符C画出的正方形。但是注意到行间距比列间距大，
 * 所以为了让结果看上去更像正方形，我们输出的行数实际上是列数的50%（四舍五入取整）。
 *
 * 示例1
 * 输入
 * 10 a
 * 输出
 * aaaaaaaaaa
 * a        a
 * a        a
 * a        a
 * aaaaaaaaaa
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Scanner input=new Scanner(System.in);
        int size=input.nextInt();
        char c=input.next().charAt(0);
        char[][] arr=new char[size/2+size%2][size];
        //第一步：把所有位置都填充成字符c
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j]=c;
            }
        }
        //第二步：把从第二行-最后一行&&第二列到最后一列的元素都置为空
        for(int i=1;i<arr.length-1;i++){
            for(int j=1;j<arr[i].length-1;j++){
                arr[i][j]=' ';
            }
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" "); //输出即可
            }
            System.out.println();
        }
*/
        int b=1;
        char a= (char) (b+'0');
        System.out.println(a);
    }
}

/**
 * [编程题]不要二
 * 链接：https://www.nowcoder.com/questionTerminal/1183548cd48446b38da501e58d5944eb
 * 来源：牛客网
 *
 * 二货小易有一个W*H的网格盒子，网格的行编号为0~H-1，网格的列编号为0~W-1。每个格子至多可以放一块蛋糕，任意两块蛋糕的欧几里得距离不能等于2。
 * 对于两个格子坐标(x1,y1),(x2,y2)的欧几里得距离为:
 * ( (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2) ) 的算术平方根
 * 小易想知道最多可以放多少块蛋糕在网格盒子里。
 *
 * 输入描述:
 * 每组数组包含网格长宽W,H，用空格分割.(1 ≤ W、H ≤ 1000)
 *
 * 输出描述:
 * 输出一个最多可以放的蛋糕数
 * 示例1
 * 输入
 * 3 2
 * 输出
 * 4
 *
 */
import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int a=input.nextInt();
        int b=input.nextInt();
        int[][] arr=new int[a][b];
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                arr[i][j]=1;
            }
        }
        int count=0;
        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){
                if(arr[i][j]==1){
                    count++;
                    //arr[i][j]这个位置是放了蛋糕的，那么离它行、列距离为2的地方就不能放
                    //将离arr[i][j]并且这一行的距离是2的那个坐标的值置为0
                    if(i+2<a){
                        arr[i+2][j]=0;
                    }
                    //将离arr[i][j]并且这一列的距离是2的那个坐标的值置为0
                    if(j+2<b){
                        arr[i][j+2]=0;
                    }
                }
            }
        }
        System.out.println(count);
    }
}

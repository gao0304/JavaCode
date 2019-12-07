import java.util.Scanner;

/**
 * [编程题]机器人走方格I
 * 链接：https://www.nowcoder.com/questionTerminal/e8bb8e68434e42acbcdff0341f2a32c5
 * 来源：牛客网
 *
 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。
 *
 * 给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
 *
 * 测试样例：
 * 2,2
 * 返回：2
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int x=scanner.nextInt();
        int y=scanner.nextInt();
        int[][] arr=new int[x][y];
    }
}

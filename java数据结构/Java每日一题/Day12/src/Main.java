/**
 * [编程题]生成格雷码
 * 链接：https://www.nowcoder.com/questionTerminal/50959b5325c94079a391538c04267e15?toCommentId=125033
 * 来源：牛客网
 *
 * 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同，
 * 则称这种编码为格雷码(Gray Code)，
 * 请编写一个函数，使用递归的方法生成N位的格雷码。
 *
 * 给定一个整数n，请返回n位的格雷码，顺序为从0开始。
 *
 * 测试样例：
 * 1
 * 返回：["0","1"]
 */
import java.util.*;
public class Main {
    public static String[] getGray(int n) {
        if(n == 1) return new String[] {"0", "1"};
        String[] s = getGray(n - 1);
        String[] res = new String[s.length * 2];
        for (int i = 0; i < s.length; i ++) {
            res[i] = "0" + s[i];
            res[s.length + i] = "1" + s[s.length - 1 - i];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getGray(n));
    }
}
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        help(s);
    }

    private static void help(String s) {

    }
}

/**
 * n个元素选m个元素的组合问题的实现. 原理如下: 从后往前选取, 选定位置i后, 再在前i-1个里面选取m-1个. 如: 1, 2, 3, 4,
 * 5 中选取3个元素. 1) 选取5后, 再在前4个里面选取2个, 而前4个里面选取2个又是一个子问题, 递归即可; 2) 如果不包含5,
 * 直接选定4, 那么再在前3个里面选取2个, 而前三个里面选取2个又是一个子问题, 递归即可; 3) 如果也不包含4, 直接选取3,
 * 那么再在前2个里面选取2个, 刚好只有两个. 纵向看, 1与2与3刚好是一个for循环, 初值为5, 终值为m. 横向看,
 * 该问题为一个前i-1个中选m-1的递归.

public void combination(char[] chars, int n, int m, char[] subchars,
                        int subn) {
    if (m == 0) { // 出口
        for (int i = 0; i < subn; ++i) {
            System.out.print(subchars[i]);
        }
        System.out.println();
    } else {
        for (int i = n; i >= m; --i) { // 从后往前依次选定一个
            subchars[m - 1] = chars[i - 1]; // 选定一个后
            combination(chars, i - 1, m - 1, subchars, subn); // 从前i-1个里面选取m-1个进行递归
        }
    }
}
 */
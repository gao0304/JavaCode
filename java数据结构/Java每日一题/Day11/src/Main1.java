/**
 * [编程题]个位数统计 (15)方法1
 * 链接：https://www.nowcoder.com/questionTerminal/a2063993dd424f9cba8246a3cf8ef445
 * 来源：牛客网
 *
 * 给定一个k位整数N = dk-1*10k-1 + ... + d1*101 + d0 (0<=di<=9, i=0,...,k-1, dk-1>0)，请编写程序统计每种不同的个位数字出现的次数。例如：给定N = 100311，则有2个0，3个1，和1个3。
 *
 * 输入描述:
 * 每个输入包含1个测试用例，即一个不超过1000位的正整数N。
 *
 * 输出描述:
 * 对N中每一种不同的个位数字，以D:M的格式在一行中输出该位数字D及其在N中出现的次数M。要求按D的升序输出。
 * 示例1
 * 输入
 * 100311
 * 输出
 * 0:2
 * 1:3
 * 3:1
 */
//方法绝妙，看看人家的！！！
//自己的方法在Main2里
import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[10];
        String n = in.next();
        for(int i = 0;i<n.length();i++){//遍历字符串中的每一个数字
            a[n.charAt(i)-'0']++;
            /*
            这里假如第一个数字是1，那么‘1’-‘0’后就是十进制的数字1，
            会把1出现的次数加1，后续如果还有1，继续把次数加1
            而且a[1]在后续输出中恰好代表的就能按0,1...9出现的次数顺序输出
            */
        }
        for(int i = 0;i<a.length;i++){
            if(a[i]!=0){ //这里把出现0次的数字给屏蔽输出
                System.out.println(i+":"+a[i]);
            }
        }
    }
}

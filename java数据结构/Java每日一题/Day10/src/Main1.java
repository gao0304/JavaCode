

/**
 * [编程题]Fibonacci数列
 * 链接：https://www.nowcoder.com/questionTerminal/18ecd0ecf5ef4fe9ba3f17f8d00d2d66?pos=11&orderByHotValue=1
 * 来源：牛客网
 *
 * Fibonacci数列是这样定义的：
 * F[0] = 0
 * F[1] = 1
 * for each i ≥ 2: F[i] = F[i-1] + F[i-2]
 * 因此，Fibonacci数列就形如：0, 1, 1, 2, 3, 5, 8, 13, ...，
 * 在Fibonacci数列中的数我们称为Fibonacci数。
 * 给你一个N，你想让其变为一个Fibonacci数，
 * 每一步你可以把当前数字X变为X-1或者X+1，
 * 现在给你一个数N求最少需要多少步可以变为Fibonacci数。
 *
 * 输入描述:
 * 输入为一个正整数N(1 ≤ N ≤ 1,000,000)
 *
 * 输出描述:
 * 输出一个最小的步数变为Fibonacci数"
 * 示例1
 * 输入
 * 15
 * 输出
 * 2
 */
import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println(fun1(n));
    }
    private static int fun1(int n) {
        int l=0,r,f0=0,f1=1,f;
        while(true){
            f=f0+f1;
            f0=f1;
            f1=f;
            //上边3步实现斐波那契数列
            if(f<n){
                l=n-f;
            }else{  //走到这里时，说明n此时是一个中间值（大于上一个斐波那契数，小于下一个）
                r=f-n;
                break;
            }
        }
        return Math.min(l,r);
        //在这里比较哪个相差的更远,因为输出的n每一可以加一或者减一，这里比较完之后直接输出就行
    }
}

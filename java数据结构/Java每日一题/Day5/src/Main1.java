/**
 * [编程题]神奇的口袋
 * 链接：https://www.nowcoder.com/questionTerminal/9aaea0b82623466a8b29a9f1a00b5d35
 * 来源：牛客网
 *
 * 有一个神奇的口袋，总的容积是40，用这个口袋可以变出一些物品，这些物品的总体积必须是40。
 * John现在有n个想要得到的物品，每个物品的体积分别是a1，a2……an。
 * John可以从这些物品中选择一些，如果选出的物体的总体积是40，那么利用这个神奇的口袋，John就可以得到这些物品。
 * 现在的问题是，John有多少种不同的选择物品的方式。
 *
 * 输入描述:
 * 输入的第一行是正整数n (1 <= n <= 20)，表示不同的物品的数目。接下来的n行，每行有一个1到40之间的正整数，分别给出a1，a2……an的值。
 *
 *
 * 输出描述:
 * 输出不同的选择物品的方式的数目。
 * 示例1
 * 输入
 * 3
 * 20
 * 20
 * 20
 * 输出
 * 3
 *
 */

import java.util.Scanner;

public class Main1 {
    static int count=0;//表示有多少种
    static int[] arr; //表示口袋
    static int n;//表示物品的种类
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        while(input.hasNext()){
            n=input.nextInt();
            arr=new int[n+1];
            /*这里的大小我们设置的比物品的种类要大1，因为在下边进行递归的时候，
            如果大小为n,因为在放第一个的时候还要考虑第一个的前一个（倒着放的：相对正着放方便一点），
            数组大小为n的话会造成数组溢出
             */
            for(int i=1;i<=n;i++){
                arr[i]=input.nextInt();
            }
        }
        count(40,n);
        System.out.println(count);
    }
    public static void count(int s,int n){
        /**
         * s表示背包剩下的容量大小
         * n表示剩下的东西数量
         */
        //如果背包容量刚好等于零，说明刚好装满
        if(s==0){
            count++;
        }
        //背包容量小于零或者容量大于零但是东西数量小于零，则不能刚好装满（也就是要么装不下了要么不够装了）
        if(s<=0||(s>0&&n<0)){
            return ;
        }
        //从最后一个开始装
        count(s-arr[n],n-1);
        //如果最后一个和其他是都值完了，从倒数第二个开始
        count(s,n-1);
    }
}

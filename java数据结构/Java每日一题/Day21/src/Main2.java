/**
 * [编程题]统计每个月兔子的总数
 * 链接：https://www.nowcoder.com/questionTerminal/1221ec77125d4370833fd3ad5ba72395
 * 来源：牛客网
 *
 * 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，
 * 假如兔子都不死，问每个月的兔子总数为多少？
 *
 * 统计出兔子总数。
 *
 * monthCount表示第几个月
 * @return 兔子总数
 *
 *public static int getTotalCount(int monthCount)
   *{
   *return 0;
   *}
   *
   *输入描述:
   *输入int型表示month
   *
   *输出描述:
   *输出兔子总数int型
   *
   *示例1
   *输入
   *9
   *输出
   *34
 */

/**
 * 对题目的分析：
 *    每个月的兔子都分为两类：1.上个月继承下来的兔子 2.这个月有生育能力生下来的兔子(每个兔子生一个)
 *      有生育能力的兔子==两个月前的兔子数量
 *      因此假设第n个月，则第n个月的兔子数量为 f(n) = f(n-1) + f(n-2)
 *      分析完毕发现这道题是斐波那契数列的变形
 */
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int monthCount=sc.nextInt();
            System.out.println(getTotalCount1(monthCount));
            //System.out.println(getTotalCount2(monthCount));
        }
    }
    //迭代版本
    private static int getTotalCount1(int monthCount) {
        if(monthCount==1||monthCount==2){
            return 1;
        }
        int first=1;
        int second=1;
        int sum=0;
        //从第三个月开始算起
        for(int i=2;i<monthCount;i++){
            sum=second+first;
            first=second;
            second=sum;
        }
        return sum;
    }
    //递归版本
    private static int getTotalCount2(int monthCount) {
        if(monthCount==1||monthCount==2){
            return 1;
        }
        //这里是倒着算的,不影响结果,因为算的次数是相同的
        return getTotalCount2(monthCount-1)+getTotalCount2(monthCount-2);
    }
}

/**
 * [编程题]组个最小数 (20)
 * 链接：https://www.nowcoder.com/questionTerminal/86ede762b450404dbab59352963378e9
 * 来源：牛客网
 *
 * 给定数字0-9各若干个。你可以以任意顺序排列这些数字，但必须全部使用。目标是使得最后得到的数尽可能小（注意0不能做首位）。例如：
 * 给定两个0，两个1，三个5，一个8，我们得到的最小的数就是10015558。
 * 现给定数字，请编写程序输出能够组成的最小的数。
 *
 * 输入描述:
 * 每个输入包含1个测试用例。每个测试用例在一行中给出10个非负整数，顺序表示我们拥有数字0、数字1、……数字9的个数。整数间用一个空
 * 格分隔。10个数字的总个数不超过50，且至少拥有1个非0的数字。
 *
 * 输出描述:
 * 在一行中输出能够组成的最小的数。
 * 示例1
 * 输入
 * 2 2 0 0 0 3 0 0 1 0  (这里的意思相当于输入了两个0，两个1，三个5，一个8)
 * 输出
 * 10015558
 */
/**
 * 2
 * 2
 * 0
 * 0
 * 0
 * 3
 * 0
 * 0
 * 1
 * 0
 */

import java.util.Scanner;
public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr2=new int[10];
        //输入0-9每个数字对应的次数用arr2保存下来
        while(sc.hasNext()){
            for(int i=0;i<arr2.length;i++){
                arr2[i]=sc.nextInt();
            }
        }
        //把arr2中的数据转化为字符串n(这里不包含出现0次的数字)
        StringBuffer n=new StringBuffer("");
        for(int i=0;i<10;i++){
            for(int j=0;j<arr2[i];j++){
                if(arr2[i]==0){
                    continue;
                }
                n.append(i);
            }
        }
        //准备用一个新的数组来存储字符串n中的数字
        int[] arr=new int[n.length()];
        for(int i=0;i<arr.length;i++){
            arr[i]=n.charAt(i)-'0';
        }
        //这里数组arr中数字已经是有序的了（因为题上的次序输入）
        StringBuffer s=new StringBuffer("");//为了最后输出一个字符串
        int i;
        for(i=0;i<arr.length;i++){ //先把出现的最小的树给输出（不是0）
            if(arr[i]!=0) {
                break;
            }
        }
        s.append(arr[i]);
        for(int j=0;j<i;j++){
            s.append(arr[j]);
        }//接着把0输出
        for(int j=i+1;j<arr.length;j++){
            s.append(arr[j]);
        } //最后把剩下的数字输出
        System.out.println(s.toString());
    }
}


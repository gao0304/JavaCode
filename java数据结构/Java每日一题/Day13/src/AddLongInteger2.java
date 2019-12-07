//方法1对加出来的数字长度最大要求是1000，虽然很大，但还是有局限
//方法2思路：
/**
 * 思路：
 * 1.首先输入两个字符串，比较两个字符串的长度，用最大的长度来设定数组的长度
 * 2.将字符串中的数字一个一个的放入到对应的数组中。注意：放的时候需要倒着放（个位放数组中第0个元素），
 *   这样是为了保证两个数进行加法运算的时候不会出现位数不够的情况。
 *   而且我们的加法竖式运算都是从个位数加起
 * 3.额外申请一个数组S，他的长度为最大字符串的长度再加一（防止出现比如999+1==1000数组长度不够的情况），
 *   除了S中最后一个元素的值为进位位，其余的S中存放的全是计算后的值。
 *   例：当i= 0时，s[0] 中放的是a数组和b数组第一个数相加后在对十求模，此时s[1]中放的是进位位。
 *      当i=1时，s[1]中放的是 a数组和b数组第二个数相加后在对十求模（覆盖了上次的值），此时s[2]中放的是进位位。
 *
 * 4.如果S数组中的最后一个元素不为0的话，那么就说明还有进位，循环需要从0开始，
 * 如果S数组中的最后一个元素为0的话，那么就说明没有进位，循环需要从1开始。输出时，从S数组中的最后一个元素开始往前输出。
 */
import java.util.*;
public class AddLongInteger2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            // 求出两个字符串中较长的那个字符串长度
            int lenA = a.length();
            int lenB = b.length();
            int lenS = Math.max(lenA, lenB);

            // S保存最终生成的结果
            int[] A = new int[lenS];
            int[] B = new int[lenS];
            int[] S = new int[lenS + 1];

            //A数组放的是a从个位数、十位数等等数字，B数字放的是b从个位数、十位数等等数字
            for (int i = 0; i < lenA; i++) {
                A[i] = a.charAt(lenA - 1 - i) - '0';
            }

            for (int i = 0; i < lenB; i++) {
                B[i] = b.charAt(lenB - 1 - i) - '0';
            }
            //关键步骤
            for (int i = 0; i < lenS; i++) {
                int sum = S[i] + A[i] + B[i];
                //sum存的是本来A，B位的数字再加上上一次进上来的位（1），没有进上来S[i]==0
                int flag = sum /10;
                //flag的作用是保存能进上去的位，进不上去为0
                S[i]  = sum % 10;
                S[i+1] += flag; //为了保证下一次sum的运算
            }

            //执行到这里后，直接逆序输出S的话可能第一位会输出0(因为我们在设定S的长度的时候多设定了一位（原因见上面）)
            for (int i = (S[lenS] == 0?1:0); i < lenS + 1; i++) {
                //如果S数组的最后一个为0的话说明多设定的那个长度是多余的，那么就在输出的时候跳过那一位
                System.out.print(S[lenS - i]); //达到逆序输出的效果
            }

            System.out.println();//牛客上做的话一定加上这个，否则很多用例的答案一起输出了（粘在一起了）

        }
        sc.close();
    }

}
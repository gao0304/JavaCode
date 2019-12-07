/**
 * [编程题]到底买不买（20）
 * 链接：https://www.nowcoder.com/questionTerminal/2f13c507654b4f878b703cfbb5cdf3a5
 * 来源：牛客网
 *
 * 小红想买些珠子做一串自己喜欢的珠串。卖珠子的摊主有很多串五颜六色的珠串，但是不肯把任何一串拆散了卖。于是小红要你帮忙判断一
 * 下，某串珠子里是否包含了全部自己想要的珠子？如果是，那么告诉她有多少多余的珠子；如果不是，那么告诉她缺了多少珠子。
 *
 * 为方便起见，我们用[0-9]、[a-z]、[A-Z]范围内的字符来表示颜色。例如，YrR8RrY是小红想做的珠串；那么ppRYYGrrYBR2258可以买，因为包含了
 * 全部她想要的珠子，还多了8颗不需要的珠子；ppRYYGrrYB225不能买，因为没有黑色珠子，并且少了一颗红色的珠子。
 *
 * 输入描述:
 * 每个输入包含1个测试用例。每个测试用例分别在2行中先后给出摊主的珠串和小红想做的珠串，两串都不超过1000个珠子。
 *
 * 输出描述:
 * 如果可以买，则在一行中输出“Yes”以及有多少多余的珠子；如果不可以买，则在一行中输出“No”以及缺了多少珠子。其间以1个空格分隔。
 * 示例1
 * 输入
 * ppRYYGrrYBR2258
 * YrR8RrY
 * 输出
 * Yes 8
 */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s1=sc.nextLine();
            String s2=sc.nextLine();
            fun(s1,s2);
        }
    }
    private static void fun(String s1, String s2) {
        int count=0;
        int i=0;
        String m1=s1;
        while(i<s2.length()) {
            for (int x = 0; x < s1.length(); x++) {
                for (; i < s2.length(); ) {
                    if (s1.charAt(x) == s2.charAt(i)) {
                        count++;
                        s1 = s1.substring(0, x) + s1.substring(x + 1);
                        x = 0;
                        i++;
                    }
                    break;
                }
            }
            i++;
        }
        if(count==s2.length()){
            System.out.print("Yes"+" ");
            System.out.println(m1.length()-count);
        }else {
            System.out.print("No"+" ");
            System.out.println(s2.length()-count);
        }
    }
}
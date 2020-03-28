//统计回文的第二种方法(相比第一种方法更好)
import java.util.Scanner;

public class Statistical_Palindrome2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int count=0;
        //第一步：截取插入并连接字符串
        //(这里用StringBuilder能解决String不可变性的短板，不用StringBuffer的原因是用不着线程安全效率快)
        for (int i = 0; i <= s1.length(); i++) {
            StringBuilder s = new StringBuilder(s1);
            s.insert(i, s2); //通过for循环在s1的每个位置都插入得到所有可能出现的字符串
            if(isPalindromic(s)){
                count++;
            }
        }
        System.out.println(count);
    }
    //第二步：判断一个字符串是否是回文字符串
    public static boolean isPalindromic(StringBuilder s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            //取出新得到的字符串挨个字符进行比较
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}


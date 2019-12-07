//统计回文的第二种方法(相比第一种方法更好)
import java.util.Scanner;

public class Statistical_Palindrome2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int count=0;
        //第一步：截取插入并连接字符串
        for (int i = 0; i <= s1.length(); i++) {
            StringBuilder s = new StringBuilder(s1);
            s.insert(i, s2);
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
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}


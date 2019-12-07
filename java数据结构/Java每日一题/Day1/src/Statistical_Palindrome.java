/**
 * [编程题]统计回文
 * 链接：https://www.nowcoder.com/questionTerminal/9d1559511b3849deaa71b576fa7009dc
 * 来源：牛客网
 *
 * “回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。
 * 花花非常喜欢这种拥有对称美的回文串，生日的时候她得到两个礼物分别是字符串A和字符串B。
 * 现在她非常好奇有没有办法将字符串B插入字符串A使产生的字符串是一个回文串。
 * 你接受花花的请求，帮助她寻找有多少种插入办法可以使新串是一个回文串。
 * 如果字符串B插入的位置不同就考虑为不一样的办法。
 * 例如：
 * A = “aba”，B = “b”。这里有4种把B插入A的办法：
 * * 在A的第一个字母之前: "baba" 不是回文
 * * 在第一个字母‘a’之后: "abba" 是回文
 * * 在字母‘b’之后: "abba" 是回文
 * * 在第二个字母'a'之后 "abab" 不是回文
 * 所以满足条件的答案为2
 *
 * 输入描述:
 * 每组输入数据共两行。
 * 第一行为字符串A
 * 第二行为字符串B
 * 字符串长度均小于100且只包含小写字母
 */
import java.util.Scanner;

public class Statistical_Palindrome {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String arr1=scanner.nextLine();
        String arr2=scanner.nextLine();
        int count=0;
        int a=0,b=1;//这里是因为为了下边先开始截取arr1设置的值
        for(int i=0;i<arr1.length()-1;i++){
            String x=quantity(arr1,a,arr2,b);
            if(isPalindromic(x)){
                count++;
            }
            //改变ab的值，让每次截取到arr1的字符串都不相同
                a++;
                b++;
        }
        //因为下边的第二步中无法做到把arr2插入到arr1的最前边或者最后边，所以这里需要特殊处理
        //当arr2直接插到arr1前边
        if(isPalindromic(arr2.concat(arr1))){
            count++;
        }
        //当arr2在arr1后边
        if(isPalindromic(arr1.concat(arr2))){
            count++;
        }
        System.out.println(count);
    }
    //第二步：截取插入并连接字符串
    public static String quantity(String s1, int a, String s2, int b){
        String arr3="";
        String arr4="";
        //在这里先把arr截取成两段字符串
        if(a<=s1.length()){
            arr3=s1.substring(0,a+1);
        }
        if(b<=s1.length()){
            arr4=s1.substring(b,s1.length());
        }
        //再把它们三个字符串连接起来
        String t1=arr3.concat(s2);
        String t2=t1.concat(arr4);
        return t2;
    }
    //第三步：判断一个字符串是否是回文字符串
    public static boolean isPalindromic (String s){
        char[] arr=s.toCharArray();
        int i=0;
        int j=arr.length-1;
        while(i<=j){
            if(arr[i]==arr[j]){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
}
/**
 * [编程题]字符集合
 * 链接：https://www.nowcoder.com/questionTerminal/784efd40ed8e465a84821c8f3970b7b5?mutiTagIds=579&orderByHotValue=0&commentTags=Python
 * 来源：牛客网
 *
 * 输入一个字符串，求出该字符串包含的字符集合
 *
 * 输入描述:
 * 每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写。
 *
 *
 * 输出描述:
 * 每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。
 * 示例1
 * 输入
 * abcqweracb
 * 输出
 * abcqwer
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.nextLine();
            String n="";
            for(int i=0;i<s.length();i++){//遍历字符串s的每个字符
                //String.valueOf(s.charAt(i)是把那个字符转换为字符串
                if(!n.contains(String.valueOf(s.charAt(i)))){
                    n+=String.valueOf(s.charAt(i));
                }
            }
            System.out.println(n);
        }
    }
}

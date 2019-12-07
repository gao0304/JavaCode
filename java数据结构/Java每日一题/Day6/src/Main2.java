/**
 *[编程题]n个数里出现次数大于等于n/2的数
 *
 链接：https://www.nowcoder.com/questionTerminal/eac8c671a0c345b38aa0c07aba40097b
 来源：牛客网

 输入n个整数，输出出现次数大于等于数组长度一半的数。

 输入描述:
 每个测试输入包含 n个空格分割的n个整数，n不超过100，其中有一个整数出现次数大于等于n/2。


 输出描述:
 输出出现次数大于等于n/2的数。
 示例1
 输入
 3 9 3 2 5 6 7 3 2 3 3 3
 输出
 3

 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Map<Integer,Integer> map=new HashMap<>();
        Scanner in = new Scanner(System.in);
        int x=0;
        while(in.hasNextInt()){
            int input=in.nextInt();
            Integer count=map.get(input);
            map.put(input,count==null?1:count+1);
            x++;
        }
        int size=map.size();
        int[] num = new int[size]; // 存储输入数字
        int[] count = new int[size]; // 存储对应数字的次数
        int i=0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            num[i] = entry.getKey();
            count[i] = entry.getValue();
            if(count[i]>=x/2){
                System.out.println(num[i]);
                break;
            }
            i++;
        }
    }
}

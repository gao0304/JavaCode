/**
 * [编程题]成绩排序
 链接：https://www.nowcoder.com/questionTerminal/0383714a1bb749499050d2e0610418b1
 来源：牛客网

 查找和排序

 题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
 都按先录入排列在前的规则处理。

 示例：
 jack      70
 peter     96
 Tom       70
 smith     67

 从高到低  成绩
 peter     96
 jack      70
 Tom       70
 smith     67

 从低到高

 smith     67

 jack      70
 Tom      70
 peter     96

 输入描述:
 输入多行，先输入要排序的人的个数，然后输入排序方法0（降序）或者1（升序）再分别输入他们的名字和成绩，以一个空格隔开

 输出描述:
 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开

 示例1
 输入
 3
 0
 fang 90
 yang 50
 ning 70
 输出
 fang 90
 ning 70
 yang 50
 */
/**
 *测试用例2：
 28
 0
 qhsq 15
 ozslg 79
 ncttmtsphb 71
 a 39
 eeiuyzsj 34
 nmlrokx 21
 pjizylo 90
 ec 45
 f 12
 sh 31
 fm 25
 ptprphubqk 29
 wxdiwv 0
 uhlcpjtxad 60
 w 20
 zwktbpun 70
 efzfkf 69
 v 31
 rsnrgtl 73
 lhdo 76
 wt 56
 mcdwd 14
 ydrnoyd 37
 gmlfds 76
 zx 1
 dqx 98
 gz 90
 kvbzrwrrjj 13
 */
import java.util.Scanner;
public class Main2 {
    private static String[] names; //用names数组存储名字
    private static int[] grades; //用grades数组存储成绩
    private static boolean compare(int i, int j, int flag){
        return flag == 0 ? grades[i] > grades[j] : grades[i] < grades[j];
    }
    private static void exch(int i, int j){ //交换
        String tempS = names[j];
        names[j] = names[i];   //互换姓名
        names[i] = tempS;
        int tempG = grades[j];
        grades[j] = grades[i]; //互换成绩
        grades[i] = tempG;
    }
    public static void sort(int flag){
        //第一次：第二个人与第一个人比较；第二次：第三个人与第二个人比较；以此类推
        for(int i = 1; i < names.length; i++){
            //前提假如是升序（flag==1）;
            //如果这个这个人成绩比他前一个人成绩小，那么【 j > 0 && compare(j,j - 1,flag)】这个条件才会满足
            //如果这个这个人成绩比他前一个人成绩大，那个直接不进入下边的for循环，直接他的下一个人和他开始比较
            for(int j = i; j > 0 && compare(j,j - 1,flag); j--){
                exch(j,j - 1); //去把他和他前一个人的成绩和姓名都互换（相当于只是换了一个位置）
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int flag = input.nextInt(); //flag为0降序，为1升序
            names = new String[n];
            grades = new int[n];
            for(int i = 0; i < n; i++){
                names[i] = input.next();
                grades[i] = input.nextInt();
            }
            sort(flag);
            //按格式输出即可
            for(int i = 0; i < n; i++){
                System.out.println(names[i] + " " + grades[i]);
            }
        }
    }
}
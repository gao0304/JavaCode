/**
 * [编程题]个位数统计 (15)方法2
 自己的方法和别人的没法比啊（死脑筋）
 缺点1：篇幅太长
 缺点2：自己的方法虽然也可以运行，但是最大支持0-2^64范围的数字，人家题目要求不超过1000位。。。
 缺点3：在输出的时候还得把0出现的次数和1-9出现的次数计算和输出分开写，虽然代码一样，
       但是就得按照提上要求的输出顺序输出
 勉强能说的过去的点：用HashMap来记录数字和对应的次数还算是亮点
 用到的思想：
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n=scanner.nextLong();
        Map<Integer,Integer> map=new HashMap<>();
        long a=n;//用临时变量a记录输入的数字n,保证下一次的n与最先开始输入的n是相同的
        for(int i=1;i<=10;i++){
            n=a; //保证下一次的n与最先开始输入的n是相同的
            int count=0;
            if(i==10){
                while(n>0){
                    if(n%10==0){
                        count++;
                    }
                    n/=10;
                }
            }else{
                while(n>0){
                    long j=n%10;
                    if(j==i){  //假如这里相等，说明这一位包含那个数字，则把次数+1
                        count++;
                    }
                    n/=10;  //然后将它除以10，抹去最后一位
                }
            }
            if(count!=0){ //这里把出现0次的数字给屏蔽输出
                map.put(i,count);
            }
        }
        int size=map.size();
        int[] num=new int[size];
        int[] count=new int[size];
        int x=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            num[x]=entry.getKey();
            count[x]=entry.getValue();
            x++;
        }
        if(num[size-1]==10){
            System.out.println("0"+":"+count[size-1]);
            for(int j=0;j<size-1;j++){
                System.out.println(num[j]+":"+count[j]);
            }
        }else{
            for(int j=0;j<size;j++){
                System.out.println(num[j]+":"+count[j]);
            }
        }
    }
}

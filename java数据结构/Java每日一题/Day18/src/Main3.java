
//[编程题]DNA序列  方法2（方法1的优化）
import java.util.Scanner;
public class Main3{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next(); //输入一个字符串
        int n=sc.nextInt();//输入int型子串的长度
        int max=0;
        int maxBefinIndex=0;
        for(int i=0;i<=s.length()-n;i++) {
            int count = 0;
            for (int j = i; j < i + n; j++) {
                if (s.charAt(j) == 'C' ||(s.charAt(j)  == 'G')){
                    count++; //用count记录出现的次数
                }
            }
            //因为这里算出来的count最后都是要除以一样的长度（计算比例大小），所以可以直接比较count大小
            if (count > max) {
                max = count;  //最外边的for循环完后，这里的max值就是所有序列里边count最大的（靠前的那个）
                maxBefinIndex = i;  //这里maxBefinIndex得到的是最大值的下标
            }
        }
        //输出时用String.substring从maxBefinIndex开始截取相应的长度即可
        System.out.println(s.substring(maxBefinIndex,maxBefinIndex+n));
    }
}
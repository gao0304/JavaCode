import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int n=sc.nextInt();
            int n1=add(n);
            int n2=add((int) Math.pow(n,2));
            System.out.println(n1+" "+n2);
        }
        sc.close();
    }
    public static int add(int n){
       String s=String.valueOf(n);//将数字n换成字符串
       int sum=0;
       for(int i=0;i<s.length();i++){
           //对于此字符串来说，要先提取出来它的每一位（这里是char类型需要先转换为String类型）转换成十进制数字，然后将字符串的每一位进行数字相加
           int x=Integer.parseInt(String.valueOf((s.charAt(i))));
           sum+=x;
       }
       return sum;
    }
}

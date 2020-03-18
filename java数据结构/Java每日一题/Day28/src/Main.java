import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n1=sc.nextInt();
            int n2=(int)Math.pow(n1,2);//1.求出n2
            // 2.先将n2转换成字符串，用字符串的截取功能将n3截取出来，再次转换为数字
            String s1=""+n2;
            String s2=s1.substring(1);
            //当n1=2或者n1=3的时候求出来的m无法进行截取，所以我们要进行排除这个
            if(s2.length()>0) {
                int n3 = Integer.parseInt(s2);
                if (n1 == n3) {//3.n3与n1进行对比即可
                    System.out.println("Yes!");
                } else {
                    System.out.println("No!");
                }
            }else {
                System.out.println("No!");
            }
        }
    }
}

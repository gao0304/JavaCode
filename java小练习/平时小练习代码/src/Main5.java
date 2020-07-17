import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s =sc.next();
            fun2(s);
            System.out.println(s);
        }
    }
    public static String fun1(String s,int count){
        StringBuffer str=new StringBuffer();
        if(count==0){
            for(int i=0;i<s.length();i=i+3){
                str.append(s.charAt(i));
                str.append(s.charAt(i+1));
                str.append(s.charAt(i+2));
                str.append(',');
            }
        }
        s=str.toString();
        return s;

    }
    public static int fun2(String s){
        int count=s.length()-1;
        for(int i=s.length()-1;i>=0;i--){
            char x=s.charAt(i);
            if(x!='.'){
                count--;
            }
        }
        return count;
    }
}
import java.util.*;
public class main7{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
           int n=sc.nextInt();
            System.out.println(fun(n));
        }
    }
    public static String fun(int k){
        String s="";
        while(k>0){
            int res=k%2;
            s=res+s;
            k=k/2;
        }
        return s;
    }
}
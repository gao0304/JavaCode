import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.nextLine();
            String[] str=new String[s.length()];
            str=s.split(" ");
            for(int i=str.length-1;i>=0;i--){
                System.out.print(str[i]+" ");
            }
        }
    }
}

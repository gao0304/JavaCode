import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.close();
        int i=0;
        for(i=2;i<n;i++){
            if(n%i==0){
                System.out.println("这个数不是素数");
                break;
            }
        }
        if(i==n){
            System.out.println("这个数是素数");
        }
    }
}

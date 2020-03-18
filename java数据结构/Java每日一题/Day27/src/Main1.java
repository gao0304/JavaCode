import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.next();
            String[] eachNumber=s.split("\\.");
            for(int i=0;i<eachNumber.length;i++){
                binaryToDecimalism(Integer.parseInt(eachNumber[i]));
            }

        }
    }

    public static void binaryToDecimalism(int n) {
        int[] arr=new int[32];
        int i=0;
        while(n/2!=0){
            int quotient=n%2;
            arr[i]=quotient;
            i++;
            n=n/2;
        }
        arr[i]=n%2;
        arr[i+1]=n/2;
        i++;
        if(i<8){
            arr[i]=0;
            i++;
        }
    }
}

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            Map<Integer,Integer> map =new HashMap<>(n);
            for(int i=0;i<n;i++){
                map.put(sc.nextInt(),i);
            }
            int x=sc.nextInt();
            if(map.containsKey(x)){
                System.out.println(map.get(x));
            }else {
                System.out.println(-1);
            }
        }
    }
}

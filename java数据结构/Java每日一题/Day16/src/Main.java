import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map<Integer,Integer> map=new HashMap<>();
        int n=sc.nextInt();
        int y=0;
        while(sc.hasNext()&&y<n){
            int input=sc.nextInt();
            Integer count=map.get(input);
            map.put(input,count==null?1:count+1);
            y++;
        }
        int n2=sc.nextInt();
        sc.close();
        int x=0;
        System.out.println(map.get(n2));
    }
}

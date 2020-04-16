import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();//选手数量
            int m=sc.nextInt();//连胜要求
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            System.out.println(arr[2]);
          /*  Queue queue=new LinkedBlockingDeque(n);
            for(int i=0;i<n;i++){
                queue.add(arr[i]);
            }
            int sum=0;
            while(sum<m){
                int x= (int) queue.poll();
                int y=(int) queue.poll();
                if(x<y){
                    queue.add(x);
                }else {
                    queue.add(y);
                    sum++;
                    if(y>(int)queue.poll()){
                        sum++;
                    }else{

                    }
                }
            }*/
        }
    }
}

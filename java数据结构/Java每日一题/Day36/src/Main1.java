import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            //步骤一
            Map<Character,Integer> map=new HashMap<>();
            String s=sc.nextLine();
            map.put('0',0);
            map.put('1',1);
            map.put('2',2);
            map.put('3',3);
            map.put('4',4);
            map.put('5',5);
            map.put('6',6);
            map.put('7',7);
            map.put('8',8);
            map.put('9',9);
            map.put('A',10);
            map.put('B',11);
            map.put('C',12);
            map.put('D',13);
            map.put('E',14);
            map.put('F',15);
            int number=0;
            int power=s.length()-3;
            //步骤二
            for(int i=2;i<s.length();i++){
                char c=s.charAt(i);
                if(map.containsKey(c)){
                    int num=map.get(c);
                    number+= (int) (num*Math.pow(16,power));
                    power--;
                }
            }
            System.out.println(number);
        }
    }
}

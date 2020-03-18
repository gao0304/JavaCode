import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            //步骤一
            Map<Character,Integer> map=new HashMap<>();
            String s=sc.nextLine();
            //步骤二
            map.put('A',0);
            map.put('B',0);
            map.put('C',0);
            map.put('D',0);
            map.put('E',0);
            map.put('F',0);
            map.put('G',0);
            map.put('H',0);
            map.put('I',0);
            map.put('J',0);
            map.put('K',0);
            map.put('L',0);
            map.put('M',0);
            map.put('N',0);
            map.put('O',0);
            map.put('P',0);
            map.put('Q',0);
            map.put('R',0);
            map.put('S',0);
            map.put('T',0);
            map.put('U',0);
            map.put('V',0);
            map.put('W',0);
            map.put('X',0);
            map.put('Y',0);
            map.put('Z',0);
            //步骤三
            for(int i=0;i<s.length();i++){
                Character c=s.charAt(i);
               if(map.containsKey(c)){
                   map.put(c,map.get(c)==0? 1 : map.get(c)+ 1);
               }
            }
            //步骤四
            for(Map.Entry<Character,Integer> entry :map.entrySet()){
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
    }
}

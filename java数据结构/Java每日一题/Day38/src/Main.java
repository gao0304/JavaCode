import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {
    public static String replaceSpace(String iniString, int length) {
       Queue queue=new ArrayBlockingQueue(length);
       for(int i=0;i<length;i++){
           queue.add(iniString.charAt(i));
       }
       StringBuffer s=new StringBuffer();
       for (int i=0;i<length;i++){
           char c= (char) queue.poll();
           if(c!=' '){
               s.append(c);
           }else {
               s.append("%20");
           }
       }
       return s.toString();
    }
    public static void main(String[] args) {
        String s1="We Are Happy";
        int n=s1.length();
        System.out.println(replaceSpace(s1,n));
    }
}

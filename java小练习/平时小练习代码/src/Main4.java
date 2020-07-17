/*

import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.nextLine();
            String s1=sc.nextLine();
            String[]  s2=s1.split(" ");
            Map<String,Integer> mm=new HashMap<String,Integer>();
            for(int i=0;i<s2.length;i++){
                if(mm.containsKey(s2[i])){
                    mm.remove(s2[i]);
                }else{
                    mm.put(s2[i],1);
                }
            }
            Set<Map.Entry<String,Integer>>  es=mm.entrySet();
            int [] arr=new int[2];
            for(Map.Entry<String,Integer>  en:es){
                if(arr[0]==0){
                    arr[0]=Integer.parseInt(en.getKey());
                }else{
                    arr[1]=Integer.parseInt(en.getKey());
                }
            }
            if(arr[0]>arr[1]){
                arr[0]=arr[0]^arr[1];
                arr[1]=arr[0]^arr[1];
                arr[0]=arr[0]^arr[1];
            }
            System.out.println(arr[0]+" "+arr[1]);
        }

    }
}
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Map<String,Integer> map=new HashMap<>();
        Scanner sc=new Scanner(System.in);
        int candidateNumber=sc.nextInt();//表示候选人数
        for(int i=0;i<candidateNumber;i++){
            sc.next();
        }
        /*for(int i=0;i<voteNumber;i++){
            voteCondition[i]=sc.next();
        }*/
        int voteNumber=sc.nextInt();//表示投票人数

        while(sc.hasNext()){
            String s=sc.next();
            Integer voteCondition=map.get(s);
            map.put(s,voteCondition==null?1:voteCondition+1);
        }

        String[] candidate=new String[candidateNumber];//表示候选人的数组
        int[] voteCondition=new int[voteNumber];//表示投票情况的数组
        for(Map.Entry<String,Integer> entry :map.entrySet()){

            System.out.println(entry.getKey()+" "+":"+" "+entry.getValue());
        }
    }
}

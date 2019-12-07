//子域名访问计数,OJ链接：https://leetcode-cn.com/problems/subdomain-visit-count/submissions/
import java.util.*;
public class InterView {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map=new HashMap<>();
        for(String cpdomain:cpdomains){
            String[] a=cpdomain.split(" ");
            int n=Integer.valueOf(a[0]);
            String domain=a[1];
            String[] b=domain.split("\\.");
            for(int i=0;i<b.length;i++){
                String[] c=Arrays.copyOfRange(b,i,b.length);
                //System.out.println(Arrays.toString(c));
                String d=String.join(".",c);
                Integer oldCount=map.get(d);
                if(oldCount==null){
                    map.put(d,n);
                }else{
                    map.put(d,oldCount+n);
                }
            }
        }
        System.out.println(map);
        List<String> ret=new ArrayList<>();
        for(Map.Entry<String,Integer> e:map.entrySet()){
            String domain=e.getKey();
            int n=e.getValue();
            String s=String.format("%d %s",n,domain);
            ret.add(s);
        }
        return ret;
    }
}

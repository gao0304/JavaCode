import java.util.Map;
import java.util.TreeMap;

public class MapDemo {
    public static void main(String[] args) {
        Map<String,String> map=new TreeMap<>();
        System.out.println(map.get("汤老师"));
        System.out.println(map.getOrDefault("汤老师","没有这个人"));
        String oldvalue=map.put("汤老师","12345678");
        //这里的oldValue的值是以前的号码，如果没有默认的返回值是null
        System.out.println(oldvalue);//输出的是null
        //System.out.println(map.get("汤老师"));
        oldvalue=map.put("汤老师","9999999");
        System.out.println(oldvalue);//输出的是12345678
        System.out.println(map.containsKey("汤老师"));
        System.out.println(map.containsKey("可老师"));
        System.out.println(map.containsValue("9999999"));
        System.out.println(map.keySet());
    }
}

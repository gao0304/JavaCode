/**
 * 练习拆分URL的各个部分
 */

import java.util.HashMap;
import java.util.Map;

public class ParseURL {
    private static Map<String,Integer> knownPorts =new HashMap<>();
    static {
        knownPorts.put("http",80);
        knownPorts.put("https",443);
        knownPorts.put("jdbc:mysql",3306);
    }
    public static void main(String[] args) {
        int index;
        String url="https://www.baidu.com/s?wd=C%2B%2B&rsv_spt=1&rsv_iqid=0xd5060e3d000f938f&issp=1&f=8&rsv_bp=1&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_dl=tb&rsv_sug3=3&rsv_sug1=1&rsv_sug7=001&rsv_sug2=0&inputT=2636&rsv_sug4=3979&rsv_sug=9";
        //1.拆分出来协议
        index=url.indexOf("://");
        String schema=url.substring(0,index);
        //返回一个字符串，该字符串是此字符串的子字符串。
        //子串开始于指定beginIndex并延伸到字符索引endIndex - 1 。 因此，子串的长度为endIndex-beginIndex 。
        url=url.substring(index+3);
        //返回一个字符串，该字符串是此字符串的子字符串。 子字符串以指定索引处的字符开头，并扩展到该字符串的末尾。
        //此时的URL为：www.baidu.com/s?wd=C%2B%2B&rsv_spt=1&rsv_iqid=0xd5060e3d000f938f&issp=1&f=8&rsv_bp=1&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_dl=tb&rsv_sug3=3&rsv_sug1=1&rsv_sug7=001&rsv_sug2=0&inputT=2636&rsv_sug4=3979&rsv_sug=9";
        System.out.println(schema);

        //2.拆分出来主机和端口号
        index=url.indexOf("/");
        String hostAndPort=url.substring(0,index);
        url=url.substring(index);
        //这里因为不知道有没有端口号，所以分开讨论
        String host;
        int port;
        if(hostAndPort.contains(":")){
            //用一个String[] group字符串来接收主机和端口号
            String[] group=hostAndPort.split(":");
            host=group[0];
            port=Integer.valueOf(group[1]);//将String类型的端口号转换为int型
        }else{
            host=hostAndPort;
            port=knownPorts.get(schema);//在上边建立的端口库里寻找它对应的端口号
        }
        System.out.println(host);
        System.out.println(port);

        //3.拆分出来资源路径信息
        index=url.indexOf("?");
        String path=url.substring(0,index);
        url=url.substring(index+1);
        //此时的URL为：wd=C%2B%2B&rsv_spt=1&rsv_iqid=0xd5060e3d000f938f&issp=1&f=8&rsv_bp=1&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_dl=tb&rsv_sug3=3&rsv_sug1=1&rsv_sug7=001&rsv_sug2=0&inputT=2636&rsv_sug4=3979&rsv_sug=9";
        System.out.println(path);

        //4.如果有queryString(查询字符串),找出来
        String queryString;
        String segment = "";
        index = url.indexOf("#");
        if (index != -1) {
            queryString = url.substring(0, index);
            segment = url.substring(index + 1);
        } else {
            queryString = url;
        }
        //5.找出文档片段
        String[] kv=queryString.split("&");
        for(String s:kv){
            System.out.println(s);
        }
        System.out.println(segment);
    }
}

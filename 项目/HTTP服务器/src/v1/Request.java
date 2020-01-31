/**
 * 请求的格式：
 *           请求行（方法  路径  版本）  \r\n或者是\n
 *           请求头（有很多行，直到一个空行出现）：key--> value
 *           可选的请求正文（业务关心的部分）
 */
package v1;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Request {
    String method;
    String path;
    String version;

    Map<String,String> parameters=new HashMap<>(); //负责存储路径的参数
    Map<String,String> headers=new HashMap<>(); //负责存储请求头

    //为了输出美观加入toString方法
    @Override
    public String toString() {
        return "Request{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", version='" + version + '\'' +
                ", parameters=" + parameters +
                ", headers=" + headers +
                '}';
    }
    static Request parse(InputStream is) throws IOException{
        Request request=new Request();
        Scanner scanner=new Scanner(is,"UTF-8");
        String line;
        //一、parseLine负责解析请求行
        parseLine(request,scanner);
        //二、解析请求头（这里的kv不要和下边的kv混合起来，是没有关系的）
        while(!(line=scanner.nextLine()).isEmpty()){
            String[] kv=line.split(":");
            String key=kv[0].trim();
            String value=kv[1].trim();
            request.headers.put(key,value);
        }
        return request;
    }

    public static void parseLine(Request request, Scanner scanner) throws IOException{
        /**请求行里我们知道包括三大部分：method path version，它们以空格间隔开来
        //比如我们这里拿https://www.baidu.com/s?wd=c%2B%2B&rsv_spt=1&rsv_iqid=0xc7ba5bfb000a1f5e 进行举例说明
         method:https
         path:www.baidu.com/s?wd=c%2B%2B&rsv_spt=1&rsv_iqid=0xc7ba5bfb000a1f5e
         version:HTTP/1.1
        */
        String line;
        line=scanner.nextLine();//读取请求行，将三大部分分别放到group数组里
        String[] group=line.split(" ");
        request.method=group[0];//读取到Method
        /**在第二部分path里又可以进行细分：比如碰到了/s?wd=c%2B%2B&rsv_spt=1&rsv_iqid=0xc7ba5bfb000a1f5e
           1.路径部分考虑需要URL解码
           2.把QueryString（查询字符串）部分分离到parameters(参数)中
         */
        String[] segment=group[1].split("\\?");//这里对?进行了转义，将path按？分为很多个部分
        request.path=segment[0];
        //同上边的方法一样，一步步的进行切割
        if(segment.length!=1){ //如果不等于1说明情况可能是这样/s?A=B&C=D?E=F&X=Y?...
            String[] kv=segment[1].split("&");//相当于形成了A=B & C=D
            for(String kvString: kv){
                String[] kv2=kvString.split("="); //再次分割形成 A = B
                String key=URLDecoder.decode(kv2[0],"UTF-8"); //这里应该按UTF-8解码
                String value="";
                if(kv2.length==2){
                    value=URLDecoder.decode(kv2[1],"UTF-8");
                }
                request.parameters.put(key,value);
            }
        }
        request.path=URLDecoder.decode(request.path,"UTF-8");
        request.version=group[2]; //读取到Version
    }
}

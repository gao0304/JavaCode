import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Request {
    //请求里边包括：
    //方法
    String method;
    //路径
    String path;
    //版本
    String version;
    //请求头 key:value
    Map<String,String> headers =new HashMap<>();//建立一个存储请求头的Map
    public static Request parse(InputStream is){
        Request request=new Request();
        Scanner scanner=new Scanner(is,"UTF-8");
        //解析请求行
        parseRequestLine(request,scanner.nextLine());
        //解析请求头直到空行出现
        String line;
        while(!(line=scanner.nextLine()).isEmpty()){
            String[] group=line.split(":");//以冒号作为分割符
            String key=group[0].trim(); //String.trim():返回一个字符串，其值为此字符串，并删除任何前导和尾随空格
            String value=group[1].trim();
            request.headers.put(key,value);//将解析出来的请求头放进Map中
        }
        return request;
        //这里下边先不写解析正文的操作
    }

    private static void parseRequestLine(Request request, String line) {
        String[] group=line.split(" ");//请求行的几个属性用空格划分开
        request.method=group[0];
        request.path=group[1];
        request.version=group[2];
    }

    @Override
    public String toString() {
        return "Request{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", version='" + version + '\'' +
                ", headers=" + headers +
                '}';
    }
}

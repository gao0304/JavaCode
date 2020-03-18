/**
 * 练习HTTP客户端代码
 */

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SimpleHttpClient{
    public static void main(String[] args) throws IOException {
        String request="GET / HTTP/1.0\r\nHost: www.baidu.com\r\n\r\n";
        Socket socket=new Socket("www.baidu.com",80);
        socket.getOutputStream().write(request.getBytes("UTF-8"));
        byte[] bytes=new byte[4096];
        int len=socket.getInputStream().read(bytes); //len是第一次读到的数据长度

        //假设4096个字节已经包含了响应行+所有响应头+ 一部分正文，
        //找正文的开始也就是找\r\n\r\n的位置（第一个\r\n是响应头的结尾换下一行，第二个\r\n是空行的结束符）
        int index=-1;
        for(int i=0;i<len-3;i++){
            if(bytes[i]=='\r'&&bytes[i+1]=='\n'&&bytes[i+2]=='\r'&&bytes[i+3]=='\n'){
                index=i;
                break;
            }
        }
        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(bytes,0,index+4);
        Scanner scanner=new Scanner(byteArrayInputStream,"UTF-8");
        String statuLine=scanner.nextLine();
        System.out.println("状态行"+statuLine);
        String[] group=statuLine.split(" ");
        System.out.println("响应版本: " + group[0].trim());//返回一个字符串，其值为此字符串，并删除任何前导和尾随空格。
        System.out.println("响应状态码: " + group[1].trim());
        System.out.println("响应状态描述: " + group[2].trim());
        String line;
        int conentLength=-1;//正文长度
        while(!(line=scanner.nextLine()).isEmpty()){
            String[] kv=line.split(":");
            String key=kv[0].trim();
            String value=kv[1].trim();
            System.out.println("响应头: " + key + " = " + value);
            //找出正文长度
            if(key.equalsIgnoreCase("content-Length")){
                conentLength=Integer.valueOf(value);
            }
        }
        System.out.println(conentLength);

        int 已经读了=len-index-4;
        int 还应该读=conentLength-已经读了;
        byte[] body=new byte[conentLength];
        System.arraycopy(bytes,index+4,body,0,已经读了);
        //这里body里边存的是bytes[4096]-状态行和响应头的部分，并不是所有的正文
        int 实际应该读 =socket.getInputStream().read(body,已经读了,还应该读);
        /*
        socket.getInputStream() :返回此套接字的输入流。
        InputStream.read(byte[] b, int off, int len) :从输入流读取最多 len字节的数据到一个字节数组。
        b - 读取数据的缓冲区。
        off - 写入数据的数组 b中的起始偏移量。
        len - 要读取的最大字节数。
        //这里读下来后body里边存的就是所有的正文了
        */
        FileOutputStream fileOutputStream=new FileOutputStream("百度首页响应正文.html");
        fileOutputStream.write(body);
    }
}
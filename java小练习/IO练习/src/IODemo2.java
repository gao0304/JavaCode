//IO之输出流
import java.io.*;
import java.net.Socket;

public class IODemo2 {
    private static OutputStream 获取一个输出流() throws IOException {
        //1.从文件中直接读
        OutputStream os1=new FileOutputStream("本地输出文件.txt");
        /**
        //2.从网络中读
        Socket socket=new Socket("www.baidu.com",80);
        OutputStream os2=socket.getOutputStream();
        //3.从内存中读
        OutputStream os3=new ByteArrayOutputStream();
        //4.从输出流中读
        //但是这里System.out的类型已经是PrintlnStream,所以这里不能直接获取它的输出流
         */
        return os1;
    }

    private static void 输出一段字符1(OutputStream os,String message) throws IOException{
    //优点：一次性就输出出去；缺点：无法格式化输出
        byte[] buffer=message.getBytes("UTF-8");
        os.write(buffer);
    }
    private static void 输出一段字符2(OutputStream os,String message) throws IOException{
        Writer writer =new OutputStreamWriter(os,"UTF-8");
        writer.append(message);//这里的message已经不需要转码了，writer会进行转码操作
        writer.flush();
    }
    private static void 输出一段字符3(OutputStream os,String message) throws IOException{
    //这里的好处就是可以进行格式化输出
       PrintWriter printWriter=new PrintWriter(os,false);
       printWriter.flush();
    }
        public static void main(String[] args) throws IOException {
        OutputStream os1=获取一个输出流();
        输出一段字符2(os1,"今天也是充满希望的一天\r\n");
    }
}

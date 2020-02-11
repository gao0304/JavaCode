//TCP的客户端
import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",8888);
        //这里其实完成了两步：1.socket.bind();  2.sock.connet();
        //1.socket.bind():将套接字绑定到本地地址 2.sock.connet():将此套接字连接到服务器
        InputStream is= socket.getInputStream();//返回此套接字的输入流。
        OutputStream os=socket.getOutputStream();//返回此套接字的输出流。

        //将字节流变为字符流
        Reader reader=new InputStreamReader(is,"UTF-8");
        BufferedReader bufferedReader=new BufferedReader(reader);
        Writer writer=new OutputStreamWriter(os,"UTF-8");
        PrintWriter printWriter=new PrintWriter(writer,false);

        String[] messages={"你好啊","我叫赛利亚","再见了勇士"};
        for(String message:messages){
            printWriter.println(message);
            printWriter.flush();

            String echoMessage=bufferedReader.readLine();
            System.out.println("对方的回复是:  "+echoMessage);
        }
        socket.close();
    }
}

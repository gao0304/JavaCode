/**不好处就是服务端每次只能连接一个客户端
  serverSocket.accept()每次只能获取一条已经建立的连接，当有一个客户端连接的
  时候，就会停滞在聊天的循环中去了，导致其他人再也连接不上

  改良方法：1.使用短连接形式解决
           2.使用多线程(实现代码在tcp.thread中)
 */
package tcp.http;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket tcpServerSocket = new ServerSocket(8080);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Socket clientSocket = tcpServerSocket.accept();
            InetAddress clientAddress = clientSocket.getInetAddress();
            int clientPort = clientSocket.getPort();
            //System.out.printf("有客户端连接上来 %s:%d%n",
            //clientAddress.getHostAddress(), clientPort);
            // 获取 字节流
            InputStream is = clientSocket.getInputStream();
            // 字节流转换为字符流
            InputStreamReader isReader = new InputStreamReader(is, "UTF-8");
            // 字符流转换缓冲字符流
            BufferedReader reader = new BufferedReader(isReader);

            // 获取输出字节流
            OutputStream os = clientSocket.getOutputStream();
            PrintStream out = new PrintStream(os, true, "UTF-8");

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("好友说: " + line);
                System.out.print("请回复> ");
                String response = scanner.nextLine();
                out.println(response);
            }
           /*
           //使用短连接方式解决
            String line=reader.readLine();
            System.out.println("好友说: " + line);
            System.out.print("请回复> ");
            String response = scanner.nextLine();
            out.println(response);
            clientSocket.close();
             */
        }
    }
}

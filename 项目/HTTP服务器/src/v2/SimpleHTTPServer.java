//服务器启动处
package v2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleHTTPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serversocket =new ServerSocket(1003); //建立连接
        ExecutorService pool= Executors.newFixedThreadPool(20);//创建一个线程池负责处理解析行和解析头的任务

        while(true){
            Socket socket=serversocket.accept();
            pool.execute(new Task(socket)); //Task负责处理各种解析
        }
    }
}
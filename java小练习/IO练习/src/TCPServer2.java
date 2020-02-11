//TCP的服务端线程池版：为了解决IO阻塞问题
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServer2 {
    private static class ServiceTask implements Runnable{
        private final Socket socket;

        private ServiceTask(Socket socket){
            this.socket=socket;
        }

        @Override
        public void run() {
            try {
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();

                Reader reader = new InputStreamReader(is, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(reader);

                Writer writer = new OutputStreamWriter(os, "UTF-8");
                PrintWriter printWriter = new PrintWriter(writer, false);

                String message;
                // 等待客户端发送数据
                while ((message = bufferedReader.readLine()) != null) { // 阻塞，沧海桑田
                    // 接收到了客户端发送来的数据
                    System.out.println("我收到一条消息: " + message);
                    printWriter.println(message);
                    printWriter.flush();
                }

                socket.close();
            } catch (IOException e) {} //先不做异常的处理
        }
    }
    public static void main(String[] args) throws IOException {
        //先建立一个大小为10的线程池（这里没有共享的数据所以不用考虑线程安全）
        ExecutorService pool=Executors.newFixedThreadPool(10);
        ServerSocket serverSocket=new ServerSocket(8888);
        while(true){
            //等待客户端建立连接
            Socket socket=serverSocket.accept();
            //有客户端建立了连接
            pool.execute(new ServiceTask(socket));
            //在将来的某个时间执行给定的命令。 该命令可以在一个新线程，一个合并的线程中或在调用线程中执行，由Executor实现。
        }
    }
}

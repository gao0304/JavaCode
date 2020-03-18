import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleHTTPServer {
    private static class Task implements Runnable{
        private final Socket socket;
        Task(Socket socket){
            this.socket=socket;
        }

        @Override
        public void run() {
            try{
                InputStream is=socket.getInputStream();//拿到输入流
                OutputStream os=socket.getOutputStream();//拿到输出流
                //解析请求
                Request request=Request.parse(is);
                System.out.println(request);
                //处理业务
                //*如果网页浏览Http://127.0.0.1就会显示一切正常
                //演示200 OK
                if(request.path.equalsIgnoreCase("/")){
                    String body="<h1>一切正常</h1>";
                    //弹窗步骤1：String body="alert('必须关掉')";
                    byte[] bodyBuffer=body.getBytes("UTF-8");
                    StringBuilder response=new StringBuilder();
                    response.append("HTTP/1.0 200 OK\r\n");
                    response.append("Content-Type:text/html;charset=UTF-8\r\n");
                    //如果这里是Content-Type:text/plain;在网页上显示的就是裸文本的形式
                    //弹窗步骤2：response.append("Content-Type:application/javascript;charset=UTF-8\r\n");
                    response.append("Content-Length:");
                    response.append(bodyBuffer.length);
                    response.append("\r\n");
                    response.append("\r\n");

                    os.write(response.toString().getBytes("UTF-8"));
                    os.write(bodyBuffer);
                    os.flush();
                }
                //*如果网页浏览Http://127.0.0.1/run实现弹窗功能，这里需要上边if{}的步骤，并且需要弹窗步骤1，2
                /**
                 * 这里实现的步骤有：我们先开始请求的是127.0.0.1/run，返回的是下边if{}里边的html格式，而这个html里边
                 * 包含着一个script标签，意思是告诉浏览器我还需要一个脚本文件（从根路径里边拿），然后浏览器就会再次请求
                 * 根路径去拿脚本文件，然后就到了上边的if{}里边的内容，这里就会告诉它返回的是JavaScript文件，文件的
                 * 内容就是alert('必须关掉')，当js看到alter就会进行弹窗处理，所以最终显示的就是 必须关掉 的字样
                 */
                //演示网页弹窗
                else if (request.path.equalsIgnoreCase("/run")) {
                    String body = "<script src='/'></script>";
                    byte[] bodyBuffer = body.getBytes("UTF-8");
                    StringBuilder response = new StringBuilder();
                    response.append("HTTP/1.0 200 OK\r\n");
                    response.append("Content-Type: text/html; charset=UTF-8\r\n");
                    response.append("Content-Length: ");
                    response.append(bodyBuffer.length);
                    response.append("\r\n");
                    response.append("\r\n");

                    os.write(response.toString().getBytes("UTF-8"));
                    os.write(bodyBuffer);
                    os.flush();
                }
                //演示307
                else if (request.path.equalsIgnoreCase("/banjia")) {
                    StringBuilder response = new StringBuilder();
                    response.append("HTTP/1.0 307 Temporary Redirect\r\n");
                    response.append("Location: /run\r\n");//这里它就会再次请求HTTP：127.0.0.1/run
                    response.append("\r\n");
                    os.write(response.toString().getBytes("UTF-8"));
                    os.flush();
                }
                //演示404
                else{
                    StringBuilder response=new StringBuilder();
                    response.append("HTTP/1.0 404 Not Found\r\n");
                    response.append("\r\n");
                    os.write(response.toString().getBytes("UTF-8"));
                    os.flush();
                }
                /*//拼接响应
                Response response=Response.build(os);
                //发送响应
                response.println(body);
                response.flush();*/
                socket.close();
            }catch (Exception e){}
        }
    }
    public static void main(String[] args) throws IOException {
        //建立连接
        ServerSocket serverSocket =new ServerSocket(80);
        //创建一个线程池负责处理解析行和解析头的任务
        ExecutorService pool= Executors.newFixedThreadPool(10);
        while (true){
            Socket socket=serverSocket.accept();//这个socket负责通知客户端
            pool.execute(new Task(socket)); //pool.execute():在将来的某个时间执行给定的命令。
        }
    }
}

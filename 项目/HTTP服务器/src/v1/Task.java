package v1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Task implements Runnable {
    private final Socket socket;
    public Task(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        try{
            InputStream is=socket.getInputStream(); //拿到输入流
            OutputStream os=socket.getOutputStream(); //拿到输出流

            Request request=Request.parse(is);//parse()负责解析请求
            Response response=new Response();//专门写Response来负责响应
            //演示访问网页：Http://127.0.0.1/joke.js
            if (request.path.equals("/joke.js")) {
                HTTPServlet servlet = new JokeJSServlet();
                servlet.doGet(request, response);
            }else {
                response.setStatus("404 Not Found");
                response.setHeader("Content-Type", "text/html; charset=utf-8");
                response.println("<h1>没有找到页面</h1>");
            }
            response.writerAndFlush(os);//writerAndFlush()负责组装发送响应
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

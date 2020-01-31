package v2;
//各种功能的入口函数
import com.sun.net.httpserver.HttpServer;
import v2.servlet.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Task implements Runnable {
    public final Socket socket;
    public Task(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        //流程：读取并解析请求->处理业务->组装并发送响应
        try{
            InputStream is=socket.getInputStream(); //拿到输入流
            OutputStream os=socket.getOutputStream(); //拿到输出流

            //一、读取并解析请求
            Request request=Request.parse(is);//parse()负责解析请求
            System.out.println(request);
            Response response=new Response();//专门写Response来负责响应
            //二、处理业务
            HTTPServlet servlet;
            //演示访问网页：Http://127.0.0.1:1003/joke
            if (request.path.equals("/joke")) {
                 servlet = new JokeServlet();
            }
            //演示307跳转:Http://127.0.0.1:1003/skip
            else if(request.path.equals("/skip")){
                 servlet=new RedirectServlet();
            }
            //演示裸文本页面:Http://127.0.0.1:1003/plain
            else if(request.path.equals("/plain")){
                 servlet=new PlainTextServlet();
            }
            //演示网页弹窗:Http://127.0.0.1:1003/run
            else if(request.path.equals("/run")){
                servlet=new RunServlet();
            }
            else if(request.path.equals("/runjoke")){
                servlet=new SkipServlet();
            }
            //演示用户登录：Http://127.0.0.1:1003/login?username=你的用户名
            else if(request.path.equals("/login")){
                //发生响应：Header:Set-Cookie:username=你的用户名
                servlet=new LoginServlet();
            }
            //验证session,以及查看个人信息:Http://127.0.0.1:1003/hello
            else if(request.path.equals("/hello")){
                servlet=new helloServlet();
            }
            //验证cookie，session,以及访问首页:Http://127.0.0.1:1003/visit?target=xxx
            else if(request.path.equals("/visit")){
                servlet=new visitHomeServlet();
            }
            //演示404页面
            else{
                 servlet=new NotFoundServlet();
            }
            servlet.doGet(request,response);//最后调用它的doGet接口,实现不同的功能
            //三、组装并发送响应
            response.writerAndFlush(os);//writerAndFlush()负责组装发送响应
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
